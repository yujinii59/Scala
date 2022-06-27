def isPrime(n: Int) =
  (2 until n).forall(d => n % d != 0)

val n = 30
(1 until n).map(i =>
  (1 until i).map(j => (i, j)))


(1 until n).map(i =>
  (1 until i).map(j => (i, j))).flatten


(1 until n).flatMap(i =>
  (1 until i).map(j => (i, j)))


(1 until n)
  .flatMap(i => (1 until i).map(j => (i, j)))
  .filter((x, y) => isPrime(x + y))