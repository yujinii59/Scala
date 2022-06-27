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

  def less(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational =
    if this.less(that) then that else this

end Rational
// end [def name] / end if 도 가능