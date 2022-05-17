def abs(x: Double) =
  if x >= 0 then x else -x

val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double): Double =
  def iterate(guess: Double): Double =
    val next = f(guess)
    println(next)
    if isCloseEnough(guess, next) then next
    else iterate(next)

  iterate(firstGuess)

def sqrt(x: Double) =
//  fixedPoint(y => x / y)(1.0)  // x = y * y => y = x / y
  fixedPoint(y => (y + x / y) / 2)(1.0) // 2y = y + x / y => y = (y + x / y) / 2

@main def test =
  sqrt(2)