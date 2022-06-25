package typelevel

// Semigroup
trait Semigroup[A] {
  def combine(a: A, b: A): A
}

// Monoid
trait Monoid[A] extends Semigroup[A] {
  def id: A
}

// Functor
trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

// Applicative
trait Applicative[F[_]] extends Functor[F] {
  def pure[A](a: A): F[A]
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
  def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)
}


