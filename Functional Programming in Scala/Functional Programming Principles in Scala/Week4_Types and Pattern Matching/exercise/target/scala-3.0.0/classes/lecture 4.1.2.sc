trait Expr:
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr

class Number(n: Int) extends Expr:
  def isNumber = true
  def isSum = false
  def numValue = n
  def leftOp = throw Error("Number.leftOp")
  def rightOp = throw Error("Number.rightOp")

class Sum(e1: Expr, e2: Expr) extends Expr:
  def isNumber = false
  def isSum = true
  def numValue = throw Error("Sum.numValue")
  def leftOp = e1
  def rightOp = e2

def isInstanceOf[T]: Boolean  // checks whether this object's type conforms to
def asInstanceOf[T]: T        // treats this object as an instance of type 'T'
                              // throws 'ClassCastException' if it isn't

def eval(e: Expr): Int =
  if e.isInstanceOf[Number] then e.asInstanceOf[Number].numValue
  else if e.isInstanceOf[Sum] then eval(e.asInstanceOf[Sum].leftOp) + eval(e.asInstanceOf[Sum].rightOp)
  else throw Error("Unknown expression " + e)
