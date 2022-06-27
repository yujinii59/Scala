def reverse[T](xs: List[T]): List[T] =
  xs.foldLeft(List[T]())((xs, x) => x :: xs)