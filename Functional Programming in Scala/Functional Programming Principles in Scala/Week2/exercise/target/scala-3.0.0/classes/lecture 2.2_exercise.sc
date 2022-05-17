def product(f: Int => Int)(a: Int, b: Int): Int =
  if a > b then 1 else f(a) * product(f)(a + 1, b)

product(x => x * x)(1, 5) // : Int = 14400

def fact(n: Int) = product(x => x)(1, n)

fact(5) //: Int = 120

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int) =
  def recur(a: Int): Int =
    if a > b then zero
    else combine(f(a), recur(a + 1))
  recur(a)

def sum(f: Int => Int) = mapReduce(f, (x, y) => x + y, 0)
def product2(f: Int => Int) = mapReduce(f, (x, y) => x * y, 1)

sum(fact)(1, 5) // : Int = 153
product2(identity)(1, 6) // : Int = 720