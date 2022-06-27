package reader.example

import cats.data.Reader

object Composition {

  val upper = Reader((text: String) => text.toUpperCase)
  val greet = Reader((name: String) => s"Hello $name")

  println(upper.compose(greet).run("Bob")) // HELLO BOB
  println(upper.andThen(greet).run("Bob")) // Hello BOB
}
