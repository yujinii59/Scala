def sum(xs: List[Int]): Int = xs match
  case Nil => 0
  case y :: ys => y + sum(ys)

// reduceLeft :
// List(x1, ..., xn).reduceLeft(op) = x1.op(x2). ... .op(xn)
def sum2(xs: List[Int]) = (0 :: xs).reduceLeft((x, y) => x + y)
def product2(xs: List[Int]) = (1 :: xs).reduceLeft((x, y) => x * y)

// write shorter
def sum3(xs: List[Int]) = (0 :: xs).reduceLeft(_ + _)
def product3(xs: List[Int]) = (0 :: xs).reduceLeft(_ * _)

// foldLeft
// List(x1, ..., xn).foldLeft(z)(op) = z.op(x1). ... .op(xn)
def sum4(xs: List[Int]) = xs.foldLeft(0)(_ + _)
def product4(xs: List[Int]) = xs.foldLeft(1)(_ * _)
