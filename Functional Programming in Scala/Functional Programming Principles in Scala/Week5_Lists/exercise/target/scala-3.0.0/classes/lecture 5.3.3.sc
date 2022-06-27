def posElem(xs: List[Int]): List[Int] = xs match
  case Nil => xs
  case y :: ys => if y > 0 then y :: posElem(ys) else posElem(ys)

extension [T](xs: List[T])
  def filter(p: T => Boolean): List[T] = xs match
    case Nil => xs
    case x :: xs1 => if p(x) then x :: xs1.filter(p) else xs.filter(p)



def posElem2(xs: List[Int], p: Int => Boolean): List[Int] =
  xs.filter(x => x > 0)

// methods
def methods_case(xs: List[Int], p: Int => Boolean) =
  xs.filterNot(p)
  xs.filter(x => !p(x)) // same as xs.filterNot(p)
  xs.partition(p) // p를 만족하는 원소들 , 만족하지 않는 원소들
  (xs.filter(p), xs.filterNot(p)) // same as xs.partition(p)
  xs.takeWhile(p) // p를 만족하는 가장 긴 prefix
  xs.dropWhile(p) // 그 나머지
  xs.span(p)
  (xs.takeWhile(p), xs.dropWhile(p)) // same as xs.span(p)

val xs = List(1,2,-3,4,-5,6)
methods_case(xs=xs, x => x > 0)

val nums = List(1,2,3,4,5,6)
nums.partition(x => x % 2 != 0)
nums.span(x => x % 2 != 0)
