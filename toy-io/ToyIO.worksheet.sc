import scala.util.Try
import scala.util.Failure
import scala.util.Success

sealed trait TIO[+A] {
  def flatMap[B](f: A => TIO[B]): TIO[B] =
    TIO.FlatMap(this, f)
  def map[B](f: A => B): TIO[B] =
    flatMap(a => TIO(f(a)))
  def *>[B](b: TIO[B]): TIO[B] =
    flatMap(_ => b)
  def recover[A](f: Throwable => TIO[A]): TIO[A] =
    TIO.Recover(this, f)
}

object TIO {
  case class Effect[A](a: () => A) extends TIO[A]
  case class FlatMap[A, B](a: TIO[A], f: A => TIO[B]) extends TIO[B]
  case class Fail(e: Throwable) extends TIO[Nothing]
  case class Recover[A, A1 <: A](a: TIO[A], f: Throwable => TIO[A1])
      extends TIO[A1]

  def apply[A](a: => A): TIO[A] = Effect(() => a)
  def fail(e: Throwable): TIO[Nothing] = Fail(e)
}

object Runtime {
  def run[A](tio: TIO[A]): Try[A] = tio match {
    case TIO.Effect(a)     => Try(a())
    case TIO.FlatMap(a, f) => run(a).flatMap(v => run(f(v)))
    case TIO.Fail(e)       => Failure(e)
    case TIO.Recover(a, f) =>
      run(a) match {
        case Success(v: A) => Success(v)
        case Failure(e) => run(f(e))
      }
  }
}

val sum = for {
  a <- TIO(1)
  b <- TIO(2)
  c <- TIO(3)
} yield a + b + c

println(Runtime.run(sum))

val recover =
  TIO
    .fail(new Exception("boom"))
    .recover(e => TIO(println(e)))

println(Runtime.run(recover))


// object Main extends App {
//   val tio = for {
//     a <- TIO(1)
//     b <- TIO(2)
//     c <- TIO(3)
//   } yield a + b + c

//   println(Runtime.run(tio))
// }
