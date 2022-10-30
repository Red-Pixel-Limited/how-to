package typeclass.reader

import cats.data.Reader

object Composition {

  val upper = Reader((text: String) => text.toUpperCase)
  val greet = Reader((name: String) => s"Hello $name")

  println(upper.compose(greet).run("Bob")) // greet("Bob") -> upper("Hello Bob") -> HELLO BOB
  println(upper.andThen(greet).run("Bob")) // upper("Bob") -> greet("BOB") -> Hello BOB
}
