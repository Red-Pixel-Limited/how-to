package fp.typeclass

import scala.language.higherKinds

trait Functor[F[_]] {
  // primitives
  def map[A, B](fa: F[A])(a2b: A => B): F[B]
}

trait Applicative[F[_]] extends Functor[F] {
  // primitives
  def pure[A](a: => A): F[A]

  def applyA[A, B](fa2b: F[A => B])(fa: F[A]): F[B]

  // derived functions
  def liftA[A, B](a2b: A => B): F[A] => F[B] =
    applyA(pure(a2b))(_)

  def liftA2[A, B, C](a2b2c: A => B => C): F[A] => F[B] => F[C] = fa => fb =>
    applyA(liftA(a2b2c)(fa))(fb)

  def applyA2[A, B, C](fa: => F[A])(fb: => F[B])(f: (A, B) => C): F[C] =
    liftA2(f.curried)(fa)(fb)

  // optional
  def sequence[A](fas: List[F[A]]): F[List[A]] =
    fas.foldRight(pure(List.empty[A]))((xs, x) => applyA2(xs)(x)(_ :: _))

//  def sequence[A](fas: List[F[A]]): F[List[A]] = {
//    def add(as: List[A])(a: A) = as :+ a
//    fas.foldLeft(pure(List.empty[A])) { case (fas, fa) =>
//      liftA2(add)(fas)(fa)
//    }
//  }
}

trait Monad[F[_]] extends Applicative[F] {
  // primitives
  def bind[A, B](fa: F[A])(f: A => F[B]): F[B]

  // derived functions
  def flatten[A](ffa: F[F[A]]): F[A] =
    bind(ffa)(identity)
}
