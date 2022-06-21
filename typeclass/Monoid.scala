package typelevel

trait Monoid[A] extends Semigroup[A] {
  def id: A
}
