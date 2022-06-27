def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  xs.foldRight(List[U]())((y, ys) => f(y) :: ys)

def lengthfun[T](xs: List[T]): Int =
  xs.foldRight(0)((y, n) => n + 1)