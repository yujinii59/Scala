def msort[T](xs: List[T])(lt: (T, T) => Boolean) : List[T] =
  val n = xs.length / 2
  if n == 0 then xs
  else
    def merge[T](xs: List[T], ys: List[T]): List[T] = (xs, ys) match
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if lt(x, y) then x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    val (fst, snd) = xs.splitAt(n) // 반으로 리스트 나누기
    merge(msort(fst), msort(snd))

val xs = List(-5, 6, 3, 2, 7)
val fruits = List("apple","pear","orange","pineapple")

msort(xs)((x: Int, y: Int) => x < y)
msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
msort(xs)((x, y) => x < y)

