class Rational(x: Int, y: Int):
  def numer = x
  def denom = y

val x = Rational(1, 2)
x.numer
x.denom

def addRational(r: Rational, s: Rational): Rational =
  Rational(
    r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom
  )

def makeString(r: Rational): String =
  s"${r.numer}/${r.denom}"

makeString(addRational(Rational(1, 2), Rational(2, 3)))