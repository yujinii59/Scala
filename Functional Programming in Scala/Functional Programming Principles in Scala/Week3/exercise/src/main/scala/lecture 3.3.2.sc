trait List[T]:
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

class CONS[T](val head: T, val tail: List[T]) extends List[T]: // parameter에 val 사용하면 부모 클래스의 성질 그대로 가져올 수 있다
  def isEmpty = false

class NIL[T] extends List[T]:
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")


def singleton[T](elem: T) = CONS[T](elem, NIL[T])

def nth[T](xs: List[T], n: Int): T =
  if xs.isEmpty then throw IndexOutOfBoundsException()
  else if n == 0 then xs.head
  else nth(xs.tail, n - 1)

nth(CONS(1, CONS(2, CONS(3, NIL()))), 1)

