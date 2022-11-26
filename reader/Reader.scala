case class Reader[A, B](run: A => B) {

  def apply(a: A): B = run(a)

  def map[C](f: B => C): Reader[A, C] = 
    Reader(run andThen f)
  
  def flatMap[C](f: B => Reader[A, C]): Reader[A, C] = 
    Reader(a => map(f)(a)(a))

  // map(f)       -- Reader[A, Reader[A, C]
  // map(f)(a)    -- Reader[A, C]
  // map(f)(a)(a) -- Reader[C]
}
