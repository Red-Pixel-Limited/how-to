import Count.Done

enum Count[+E]:
  case Cons(head: E, tail: Count[E])
  case Done
  def ::[E2 >: E](other: E2): Count[E2] =
    Cons(other, this)

val count = 1 :: 2 :: 3 :: Done // count: Count[Int] = Cons(1,Cons(2,Cons(3,Done)))
