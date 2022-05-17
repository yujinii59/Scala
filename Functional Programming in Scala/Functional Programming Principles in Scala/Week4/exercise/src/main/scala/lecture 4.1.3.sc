trait Expr:
  def eval: Int
  def show: Int

class Number(n: Int) extends Expr:
  def eval: Int = n
  def show: Int = ???

class Sum(e1: Expr, e2: Expr) extends Expr:
  def eval: Int = e1.eval + e2.eval
  def show: Int

 