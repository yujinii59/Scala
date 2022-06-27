enum Direction(val dx: Int, val dy: Int):
  case Right extends Direction(1, 0) // ordinal = 0
  case Up extends Direction(0, 1) // ordinal = 1
  case Left extends Direction(-1, 0) // ordinal = 2
  case Down extends Direction(0, -1) // ordinal = 3

  def leftTurn = Direction.values((ordinal + 1) % 4) // Direction 의 첫번째 case 부터 하나씩 내려가는 형태.
                                                     // 한번 선언 -> right, 두번 선언 -> up
end Direction

val r = Direction.Right
val u = r.leftTurn
val v = (u.dx, u.dy)