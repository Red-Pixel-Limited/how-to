object Curried {

  // given
  val f1: (Int, Int) => Int    = (a, b) => a + b
  val f2: Int => String        = _.toString
  // function composition
  val f3: (Int, Int) => String = (a, b) => f2.compose(f1.curried(a))(b)
  val f4: (Int, Int) => String = (a, b) => f1.curried(a).andThen(f2)(b)

}
