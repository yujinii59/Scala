//abstract class JSON
//object JSON:
//  case class Seq(elem: List[JSON])            extends JSON
//  case class Obj(bindings: Map[String, JSON]) extends JSON
//  case class Num(num: Double)                 extends JSON
//  case class Str(str: String)                 extends JSON
//  case class Bool(b: Boolean)                 extends JSON
//  case object Null                            extends JSON

enum JSON:
  case Seq(elem: List[JSON])
  case Obj(bindings: Map[String, JSON])
  case Num(num: Double)
  case Str(str: String)
  case Bool(b: Boolean)
  case Null
