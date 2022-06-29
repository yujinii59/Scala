def expr =
  val x = { print("x"); 1 }
  lazy val y = { print("y"); 2 }
  def z = { print("z"); 3 }
  z + y + x + z + y + x

expr

lazy val x = expr
x


/*
lazyRange(1000, 10000).filter(isPrime).apply(1)
 => (if 1000 >= 10000 then empty
    else cons(1000, lazyRange(1000 + 1, 10000))
    .filter(isPrime).apply(1)

 => cons(1000, lazyRange(1000 + 1, 10000))
    .filter(isPrime).apply(1)

C1 = cons(1000, lazyRange(1000 + 1, 10000))

C1.filter(isPrime).apply(1)
 => (if C1.isEmpty then C1
     else if isPrime(C1.head) then cons(C1.head, C1.tail.filter(isPrime))
     else C1.tail.filter(isPrime))
    .apply(1)

 => (if isPrime(C1.head) then cons(C1.head, C1.tail.filter(isPrime))
     else C1.tail.filter(isPrime))
    .apply(1)

 => (if isPrime(1000) then cons(C1.head, C1.tail.filter(isPrime))
     else C1.tail.filter(isPrime))
    .apply(1)

 => (if false then cons(C1.head, C1.tail.filter(isPrime))
     else C1.tail.filter(isPrime))
    .apply(1)

 => C1.tail.filter(isPrime).apply(1)

 => lazyRange(1001, 10000).filter(isPrime).apply(1)

...

 => lazyRange(1009, 10000).filter(isPrime).apply(1)

 => cons(1009, lazyRange(1009 + 1, 10000)).filter(isPrime).apply(1)

C2 = cons(1009, lazyRange(1009 + 1, 10000))

 => cons(1009, C2.tail.filter(isPrime)).apply(1)

 => if 1 == 0 then cons(1009, C2.tail.filter(isPrime)).head
    else cons(1009, C2.tail.filter(isPrime)).tail.apply(0)

 => cons(1009, C2.tail.filter(isPrime)).tail.apply(0)

 => C2.tail.filter(isPrime).apply(0)

 => lazyRange(1010, 10000).filter(isPrime).apply(0)

...

 => lazyRange(1013, 10000).filter(isPrime).apply(0)

 => cons(1013, lazyRange(1013 + 1, 10000)).filter(isPrime).apply(0)

C3 = cons(1013, lazyRange(1013 + 1, 10000))

 => cons(1013, C2.tail.filter(isPrime)).apply(0)

 => 1013

*/

class LazyList[+T](init: => State[T]):
  lazy val state: State[T] = init

enum State[T]:
  case Empty
  case Cons(hd: T, tl: LazyList[T])