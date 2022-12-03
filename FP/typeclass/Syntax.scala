package fp.typeclass

import scala.language.higherKinds

trait syntax {

  implicit class IdOps[A](a: A) {
    def pure[F[_]](implicit F: Applicative[F]): F[A] = F.pure(a)
  }

  implicit class FunctorOps[F[_], A](fa: F[A])(implicit F: Functor[F]) {
    def map[B](a2b: A => B): F[B] = F.map(fa)(a2b)
  }

  implicit class ApplicativeOps[F[_], A, B](fa2b: F[A => B])(implicit F: Applicative[F]) {
    def <*>(fa: F[A]): F[B] = F.applyA(fa2b)(fa)
  }

  implicit class ApplicativeOps2[F[_], A, B](a2b: A => B)(implicit F: Applicative[F]) {
    def <*>(fa: F[A]): F[B] = F.applyA(F.pure(a2b))(fa)
  }

  implicit class MonadOps[F[_], A](fa: F[A])(implicit F: Monad[F]) {
    def flatMap[B](f: A => F[B]): F[B] = F.bind(fa)(f)
  }

  implicit class SequenceOps[F[_], A](as: List[F[A]])(implicit F: Applicative[F]) {
    def sequence: F[List[A]] = F.sequence(as)
  }
  
}
