def isPrime(n: Int) =
  (2 until n).forall(d => n % d != 0)

val n = 30
for
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
yield (i, j)
