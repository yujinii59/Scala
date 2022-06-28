extension [T](xs: List[T])
  def map[U](f: T => U): List[U] = xs match
    case x :: xs1 => f(x) :: xs1.map(f)
    case Nil => Nil


  def flatMap[U](f: T => List[U]): List[U] = xs match
    case x :: xs1 => f(x) ++ xs1.flatMap(f)
    case Nil => Nil


  def filter(p: T => Boolean): List[U] = xs match
    case x :: xs1 =>
      if p(x) then x :: xs1.filter(p) else xs1.filter(p)
    case Nil => Nil


val n = 30
(1 until n)(i =>
  (1 until i) filter (j => isPrime(i + j)) map
    (j => (i, j)))


for
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
yield (i, j)

