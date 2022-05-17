class Rational(x: Int, y: Int):
  require(y > 0, "denominator must be positive") // inform variable condition
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  //  private val g = gcd(x, y)
  //  def numer = x / g
  //  def denom = y / g

  val numer = x / gcd(x.abs, y)
  val denom = y / gcd(x.abs, y)
  def add(r: Rational) =
    Rational(numer * r.denom + r.numer * denom, denom * r.denom)

  def mul(r: Rational) =
    Rational(numer * r.numer, denom * r.denom)

  def neg = Rational(-numer, denom)

  def sub(r: Rational) = add(r.neg)

  def less(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational =
    if this.less(that) then that else this

  override def toString = s"${numer / gcd(x.abs, y)} / ${denom / gcd(x.abs, y)}"

end Rational

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)
x.add(y).mul(z)
x.sub(y).sub(z)
Rational(2)