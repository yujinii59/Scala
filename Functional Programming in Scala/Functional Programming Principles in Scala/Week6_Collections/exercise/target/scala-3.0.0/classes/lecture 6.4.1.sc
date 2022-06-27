val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")

val countryOfCapital = capitalOfCountry.map((x, y) => (y, x))
capitalOfCountry("US")
capitalOfCountry("Andorra")

capitalOfCountry.get("US") // Some(x) : if map associates the given key with the value x
capitalOfCountry.get("Andorra") // None : if map does not contain the given key

def showCapital(country: String) = capitalOfCountry.get(country) match
  case Some(capital) => capital
  case None => "missing data"

showCapital("US")
showCapital("Andorra")

capitalOfCountry + ("Japan" -> "Tokyo")
val newCapitalOfCountry = Map("China" -> "Beijing", "UK" -> "London")
capitalOfCountry ++ newCapitalOfCountry

val fruit = List("apple","pear","orange","pineapple")
fruit.sortWith(_.length < _.length)
fruit.sorted

fruit.groupBy(_.head)

Map(0 -> 5, 1 -> -2, 2 -> 0, 3 -> 1) // x^3 - 2x + 5

val cap1 = capitalOfCountry.withDefaultValue("<unknown>")
cap1("Andorra")