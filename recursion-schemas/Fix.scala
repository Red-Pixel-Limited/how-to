
case class Fix[F[_]: Functor](unfix: F[Fix[F]]):
  def cata[A](f: F[A] => A): A = f {
    Functor[F].map(unfix)(_.cata(f))
  }

  