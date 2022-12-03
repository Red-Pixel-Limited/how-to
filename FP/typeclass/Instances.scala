package fp.typeclass

sealed trait Validation[+A]

case class Success[A](a: A)          extends Validation[A]
case class Error(msgs: List[String]) extends Validation[Nothing]

object Validation {
  def cond[A](predicate: Boolean, onSuccess: => A, errors: String*): Validation[A] =
    if (predicate) Success(onSuccess) else Error(errors.toList)
}

trait instances {
  implicit val validationInstance: Monad[Validation] =
    new Monad[Validation] {
      override def pure[A](a: => A): Validation[A] =
        Success(a)

      override def map[A, B](aV: Validation[A])(a2b: A => B): Validation[B] =
        aV match {
          case Success(a)   => pure(a2b(a))
          case error: Error => error
        }

      override def applyA[A, B](a2bV: Validation[A => B])(aV: Validation[A]): Validation[B] =
        (a2bV, aV) match {
          case (Success(a2b), Success(a)) => pure(a2b(a))
          case (Success(_), error: Error) => error
          case (error: Error, Success(_)) => error
          case (Error(lst1), Error(lst2)) => Error(lst1 ++ lst2)
        }

      override def bind[A, B](aV: Validation[A])(f: A => Validation[B]): Validation[B] =
        aV match {
          case Success(a)   => f(a)
          case error: Error => error
        }
    }
}
