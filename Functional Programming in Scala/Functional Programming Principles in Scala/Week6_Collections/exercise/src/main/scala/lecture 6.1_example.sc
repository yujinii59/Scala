val M = 50
val N = 30
(1 to M).flatMap(x => (1 to N).map(y => (x, y)))


def scalaProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  xs.zip(ys).map((x, y) => x * y).sum

def scalaProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  xs.zip(ys).map(xy => xy._1 * xy._2).sum

def scalaProduct3(xs: Vector[Double], ys: Vector[Double]): Double =
  xs.zip(ys).map(_ * _).sum

val num1 = Vector(1.0,2.0,3.0,4.0)
val num2 = Vector(2.0,3.0,4.0,5.0)

scalaProduct(num1, num2)
scalaProduct2(num1, num2)
scalaProduct3(num1, num2)