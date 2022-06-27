// Case class

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

// example
def eval(e: Expr): Int = e match
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)

  // pattern => expr 형태

eval(Sum(Number(1), Number(2)))
// -> Sum(Number(1), Number(2)) match
//      case Number(n) => n
//      case Sum(e1, e2) => eval(e1) + eval(e2)

// -> eval(Number(1)) + eval(Number(2))

// -> Number(1) match case...  + eval(Number(2))

// -> 1 + Number(2) match case ...

// -> 1 + 2
