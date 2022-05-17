trait Expr:
  def isNumber: Boolean
  def isVar: Boolean
  def isSum: Boolean
  def isProd: Boolean
  def numValue: Int
  def varName: Int
  def leftOp: Expr
  def rightOp: Expr

class Number(n: Int) extends Expr:
  def isNumber = true
  def isVar = false
  def isSum = false
  def isProd = false
  def numValue = n
  def varName = throw Error("Number.varName")
  def leftOp = throw Error("Number.leftOp")
  def rightOp = throw Error("Number.rightOp")

class Var(s: String) extends Expr:
  def isNumber = false
  def isVar = true
  def isSum = false
  def isProd = false
  def numValue = throw Error("Var.numValue")
  def varName = s.length
  def leftOp = throw Error("Var.leftOp")
  def rightOp = throw Error("Var.rightOp")

class Sum(e1: Expr, e2: Expr) extends Expr:
  def isNumber = false
  def isVar = false
  def isSum = true
  def isProd = false
  def numValue = throw Error("Sum.numValue")
  def varName = throw Error("Sum.varName")
  def leftOp = e1
  def rightOp = e2

class Prod(e1: Expr, e2: Expr) extends Expr:
  def isNumber = false
  def isVar = false
  def isSum = false
  def isProd = true
  def numValue = throw Error("Prod.numValue")
  def varName = throw Error("Prod.varName")
  def leftOp = e1
  def rightOp = e2

def eval(e: Expr): Int =
  if e.isNumber then e.numValue
  else if e.isVar then e.varName
  else if e.isSum then eval(e.leftOp) + eval(e.rightOp)
  else if e.isProd then eval(e.leftOp) + eval(e.rightOp)
  else throw Error("Unknown expression " + e)