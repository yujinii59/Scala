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

def lazyRange(lo: Int, hi: Int): LazyList[Int] =
  if lo >= hi then LazyList.empty
  else LazyList.cons(lo, lazyRange(lo + 1, hi))

def listRange(lo: Int, hi: Int): List[Int] =
  if lo >= hi then Nil
  else lo :: listRange(lo + 1, hi)

lazyRange(10, 30).toList
listRange(10, 30)

LazyList.range(1000, 10000).filter(isPrime)(1)