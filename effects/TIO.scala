import scala.util.Try
import scala.util.Failure
import scala.util.Success

sealed trait TIO[+A] {
  def flatMap(f: A => TIO[A]): TIO[A] =
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
        case Failure(e)    => run(f(e))
      }
  }
}
