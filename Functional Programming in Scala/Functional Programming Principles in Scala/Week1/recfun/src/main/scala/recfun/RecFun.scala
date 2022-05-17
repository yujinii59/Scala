package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def factorial(n: Int): Int =
    if n == 0 then 1 else n * factorial(n - 1)

  def pascal(c: Int, r: Int): Int =
    factorial(r) / (factorial(r - c) * factorial(c))

  /**
   * Exercise 2
   */
  def char_count(cnt: Int, chars: List[Char]): Boolean =
    if chars.isEmpty then
      if cnt == 0 then
        true
      else
        false
    else {
      val char = chars.head
      if char == '(' then
        char_count(cnt + 1, chars.tail)
      else if char == ')' then
        if cnt - 1 < 0 then
          false
        else
          char_count(cnt - 1, chars.tail)
      else
        char_count(cnt, chars.tail)
    }


  def balance(chars: List[Char]): Boolean =
    if chars.isEmpty then
      false
    else
      char_count(0, chars)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if coins.isEmpty then
      0
    else {
//      println(money)
//      println(coins.head)
      val coin = coins.head
      var cnt = 0
      if (money > coin) {
        countChange(money - coin, coins) + countChange(money, coins.tail)

      } else if (money == coin){
        1
      } else{
        0
      }

    }