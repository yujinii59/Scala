// (xs ++ ys) ++ zs = xs ++ (ys ++ zs)
// xs ++ Nil = xs
// Nil ++ xs = xs

// induction
def factorial(n: Int): Int =
  if n == 0 then 1
  else n * factorial(n - 1)

// if n >= 4 then factorial(n) >= power(2, n) (2^n)
// =>  factorial(n + 1) == (n + 1) * factorial(n)
//                      >  2 * factorial(n)
//                      >= 2 * power(2, n)
//                      == power(2, n + 1)

