import cats.syntax.semigroup._
import cats.kernel.Monoid

def sum[A](list: List[A])(using m: Monoid[A]): A =
  list.foldLeft(m.empty)(m.combine)

