def squareList(xs: List[Int]): List[Int] = xs match
  case Nil => Nil
  case y :: ys => y * y :: squareList(ys)

extension [T](xs: List[T])
  def map[U](f: T => U): List[U] = xs match
    case Nil => xs
    case x :: xs1 => f(x) :: xs1.map(f)

def squareList2(xs: List[Int]): List[Int] =
  xs.map(x => x * x)
