def square(x: Double) = x * x
def abs(x: Double) = if x > 0 then x else -x

def sqrt(x: Double) = {
//  def sqrtIter(guess: Double, x: Double): Double =
//    if isGoodEnough(guess, x) then guess
//    else sqrtIter(improve(guess, x), x)
  def sqrtIter(guess: Double): Double =
    if isGoodEnough(guess) then guess
    else sqrtIter(imporove(guess))

//  def imporove(guess: Double, x: Double) =
//    (guess + x / guess) / 2
  def imporove(guess: Double) =
    (guess + x / guess) / 2

//  def isGoodEnough(guess: Double, x: Double) =
//    abs(square(guess) - x) < 0.001
  def isGoodEnough(guess:** Double) =
    abs(square(guess) - x) < 0.001

//  sqrtIter(1.0, x)
  sqrtIter(1.0)
}

@main def test = println(sqrt(2))


//val x = 0
//def f(y: Int) = y + 1
//val result = {
//  val x = f(3)
//  x * x
//}


val x = 0
def f(y: Int) = y + 1
val y = {
  val x = f(3)
  x * x
}
val result = y + x



