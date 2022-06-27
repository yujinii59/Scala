def pack[T](xs: List[T]): List[List[T]] = xs match
  case Nil => Nil
  case x :: xs1 =>
    val (more, rest) = xs1.span(y => y == x)
    (x :: more) :: pack(rest)

val elems = List("a","a","a","b","c","c","a")
pack(elems)
List(List("a","a","a"), List("b"), List("c","c"), List("a"))

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs).map(x => (x.head, x.length))

encode(elems)
List(("a", 3), ("b", 1), ("c", 2), ("a", 1))