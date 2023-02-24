trait Show[A]:
  def show(a: A): String

object Show:
  given Show[Int] with
    def show(value: Int) = value.toString

def showInt(value: Int): String =
  summon[Show[Int]].show(value)
