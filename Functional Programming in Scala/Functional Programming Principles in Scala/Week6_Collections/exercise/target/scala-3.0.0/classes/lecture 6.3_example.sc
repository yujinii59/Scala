def queens(n: Int) =
  def placeQueens(k: Int): Set[List[Int]] =
    if k == 0 then Set(List())
    else
      for
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      yield col :: queens
  placeQueens(n)


  def isSafe(col: Int, queens: List[Int]): Boolean =
    !checks(col, 1, queens)


  def checks(col: Int, delta: Int, queens: List[Int]): Boolean = queens match
    case qcol :: others =>
      qcol == col
      || (qcol - col).abs == delta
      || checks(col, delta + 1, others)
    case Nil =>
      false