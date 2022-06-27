extension [T](xs: List[T])
  def map[U](f: T => U): List[U] = xs match
    case Nil => xs
    case x :: xs1 => f(x) :: xs1.map(f)

def scaleList(xs: List[Double], factor: Double): List[Double] =
  xs.map(x => x * factor)
