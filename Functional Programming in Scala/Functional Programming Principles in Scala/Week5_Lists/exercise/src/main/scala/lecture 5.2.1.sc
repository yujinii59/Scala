extension [T](xs: List[T])
  def splitAt(n: Int) = (xs.take(n), xs.drop(n)) case class Tuple2[T1, T2](_1: +T1, _2: +T2):
  override def toString = "(" + _1 + "," + _2 + ")"

val xs = List('a','b','c','d')
xs.splitAt(2)

case class Tuple2[T1, T2](_1: +T1, _2: +T2):
  override def toString = "(" + _1 + "," + _2 + ")"

def msort(xs: List[Int]): List[Int] =
  val n = xs.length / 2
  if n == 0 then xs
  else
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if x < y then x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    val (fst, snd) = xs.splitAt(n) // 반으로 리스트 나누기
    merge(msort(fst), msort(snd))

val pair = ("answer", 42)
val (label, value) = pair

val pair = Tuple2("answer", 42)
val label = pair._1
val value = pair._2