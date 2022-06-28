val jsData = JSON.Obj(Map(
  "firstName" -> JSON.Str("John"),
  "lastName" -> JSON.Str("Smith"),
  "address" -> JSON.Obj(Map(
    "streetAddress" -> JSON.Str("21 2nd Street"),
    "state" -> JSON.Str("NY"),
    "postalCode" -> JSON.Num(10021)
  )),
  "phoneNumbers" -> JSON.Seq(List(
    JSON.Obj(Map(
      "type" -> JSON.Str("home"),
      "number" -> JSON.Str("212 555-1234")
    )),
    JSON.Obj(Map(
      "type" -> JSON.Str("fax"),
      "number" -> JSON.Str("646 555-4567")
    ))
  ))
))

def inQuotes(str: String): String = "\"" + str + "\""

def show(json: JSON): String = json match
  case JSON.Seq(elems) =>
    elems.map(show).mkString("[", ", ", "]")
  case JSON.Obj(bindings) =>
    val assocs = bindings.map(
      (key, value) => s"${inQuotes(key)}: ${show(value)}"
    )
    assocs.mkString("{", ",\n", "}")
  case JSON.Num(num) => num.toString
  case JSON.Str(str) => inQuotes(str)
  case JSON.Bool(b) => b.toString
  case JSON.Null => "null"

show(jsData)


def bindings(x: JSON): List[(String, JSON)] = x match
  case JSON.Obj(bindings) => bindings.toList
  case _ => Nil

for
  case ("phoneNumbers", JSON.Seq(numberInfos)) <- bindings(jsData)
  numberInfo <- numberInfos
  case ("number", JSON.Str(number)) <- bindings(numberInfo)
  if number.startsWith("212")
yield
  number  