case class Player(marker: Char) {
  def makeMove(board: Board): Boolean = {
    println(s"Player $marker, enter row and column numbers (0, 1, or 2):")
    val row = scala.io.StdIn.readInt()
    val col = scala.io.StdIn.readInt()

    board.placeMark(row, col, marker)
  }
}
