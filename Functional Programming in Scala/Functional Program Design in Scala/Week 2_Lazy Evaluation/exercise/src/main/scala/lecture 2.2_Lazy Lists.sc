import scala.None.isEmpty
import java.util.NoSuchElementException

def isPrime(n: Int) =
  (2 until n).forall(d => n % d != 0)

(1000 to 10000).filter(isPrime)(1)
def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
def nthPrime(from: Int, to: Int, n: Int): Int =
  if from >= to then throw Error("no prime")
  else if isPrime(from) then
    if n == 1 then from else nthPrime(from + 1, to, n - 1)
  else nthPrime(from + 1, to, n)

val xs = LazyList.cons(1, LazyList.cons(2, LazyList.empty))
LazyList(1, 2, 3)

(1 to 1000).to(LazyList)

//def lazyRange(lo: Int, hi: Int): LazyList[Int] =
//  if lo >= hi then LazyList.empty
//  else LazyList.cons(lo, lazyRange(lo + 1, hi))

def lazyRange(lo: Int, hi: Int): TailLazyList[Int] =
  print(lo+" ")
  if lo >= hi then TailLazyList.empty
  else TailLazyList.cons(lo, lazyRange(lo + 1, hi))

def listRange(lo: Int, hi: Int): List[Int] =
  if lo >= hi then Nil
  else lo :: listRange(lo + 1, hi)

lazyRange(10, 30).toList
listRange(10, 30)

LazyList.range(1000, 10000).filter(isPrime)(1)

/*
x :: xs => list
x #:: xs => LazyList.cons(x, xs)  // #:: - hash cons
*/


trait TailLazyList[+A] extends Seq[A]:
  def isEmpty: Boolean
  def head : A
  def tail: TailLazyList[A]

object TailLazyList:
  def cons[T](hd: T, tl: => TailLazyList[T]) = new TailLazyList[T]:
    def isEmpty = false
    def head = hd
    def tail = tl
    override def toString = "LazyList(" + hd + ", ?)"

  val empty = new TailLazyList[Nothing]:
    def isEmpty = true
    def head = throw NoSuchElementException("empty.head")
    def tail = throw NoSuchElementException("empty.tail")
    override def toString = "LazyList()"

  extension [T](xs: TailLazyList[T])
    def filter(p: T => Boolean): TailLazyList[T] =
      if isEmpty then xs
      else if p(xs.head) then cons(xs.head, xs.tail.filter(p))
      else xs.tail.filter(p)


lazyRange(1, 10).take(3).toList