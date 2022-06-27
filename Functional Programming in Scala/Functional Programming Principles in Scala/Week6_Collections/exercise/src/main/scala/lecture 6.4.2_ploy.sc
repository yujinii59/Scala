class Polynom(nonZeroTerms: Map[Int, Double]):

  val terms = nonZeroTerms.withDefaultValue(0.0)

  def + (other: Polynom): Polynom =
    Polynom(terms ++ other.terms.map((exp, coeff) => (exp, terms(exp) + coeff)))

  override def toString: String =
    val termStrings =
      for (exp, coeff) <- terms.toList.sorted.reverse
      yield
        val exponent = if exp == 0 then "" else s"x^$exp"
        s"$coeff$exponent"
    if terms.isEmpty then "0"
    else termStrings.mkString(" + ")


val x = Polynom(Map(0 -> 2, 1 -> 3, 2 -> 1))
val z = Polynom(Map())
x + x + z