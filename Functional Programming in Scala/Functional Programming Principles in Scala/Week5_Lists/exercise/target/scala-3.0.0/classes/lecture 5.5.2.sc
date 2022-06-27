extension [T](xs: List[T])
  def ++ (ys: List[T]) = xs match
    case Nil => ys
    case x :: xs1 => x :: (xs1 ++ ys)

// base case : Nil
// (Nil ++ ys) ++ zs == ys ++ zs
// Nil ++ (ys ++ zs) == ys ++ zs

// induction step : x :: xs
// LHS
// ((x :: xs) ++ ys) ++ zs = (x :: (xs ++ ys)) ++ zs
//                         = x :: ((xs ++ ys) ++ zs)
//                         = x :: (xs ++ (ys ++ zs))
// RHS
// (x :: xs) ++ (ys ++ zs) = x :: (xs ++ (ys ++ zs))
// => LHS == RHS