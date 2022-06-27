def scalaProduct(xs: List[Double], ys: List[Double]): Double =
  (for (x, y) <- xs.zip(ys) yield x * y).sum

def scalaProduct2(xs: List[Double], ys: List[Double]): Double =
  (for x <- xs; y <- ys yield x * y).sum

val test1 = List(1,2,3,4.0)
val test2 = List(5,6,7,8.0)
scalaProduct(test1, test2)  // List(5.0, 12.0, 21.0, 32.0)
scalaProduct2(test1, test2)  // List(5.0, 6.0, 7.0, 8.0, 10.0, 12.0, 14.0, 16.0, 15.0, 18.0, 21.0, 24.0, 20.0, 24.0, 28.0, 32.0)
