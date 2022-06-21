package typelevel

trait Semigroup[A] {
  def combine(a: A, b: A): A
}
