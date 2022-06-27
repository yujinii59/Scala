def isPrime(n: Int) =
  (2 until n).forall(d => n % d != 0)


isPrime(143)

