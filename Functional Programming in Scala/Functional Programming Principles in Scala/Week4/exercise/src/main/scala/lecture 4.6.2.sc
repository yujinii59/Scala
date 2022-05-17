trait List[+T]:

  def isEmpty = this match
    case Nil => true
    case _ => false

//  def prepend(elem: T): List[T] = ::(elem, this) // prepend fails cariance checking
  def prepend[U >: T](elem: U): List[U] = ::(elem, this)

  override def toString =
    def recur(prefix: String, xs: List[T]): String = xs match
      case x :: xs1 => s"$prefix$x${recur(", " , xs1)}"
      case Nil => ")"

    recur("List(", this)

case class ::[+T](head: T, tail: List[T]) extends List[T]
case object Nil extends List[Nothing]

extension [T](x: T) def ::(xs: List[T]): List[T] = ::(x, xs)

object List:
  def apply() = Nil
  def apply[T](x: T) = x :: Nil
  def apply[T](x1: T, x2: T) = x1 :: x2 :: Nil