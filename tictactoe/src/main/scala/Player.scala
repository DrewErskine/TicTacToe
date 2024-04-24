case class Player(marker: Char, isAI: Boolean = false) {
  def makeMove(board: Board): Boolean = {
    if (!isAI) {
      println(s"Player $marker, enter row and column numbers (0, 1, or 2):")
      val row = scala.io.StdIn.readInt()
      val col = scala.io.StdIn.readInt()
      board.placeMark(row, col, marker)
    } else {
      val availableMoves = for {
        row <- 0 to 2
        col <- 0 to 2
        if board.isSpotAvailable(row, col)
      } yield (row, col)

      if (availableMoves.nonEmpty) {
        val (row, col) = availableMoves(scala.util.Random.nextInt(availableMoves.length))
        board.placeMark(row, col, marker)
        println(s"AI $marker placed a mark at ($row, $col)")
        true // Return true indicating a successful move
      } else {
        false // Return false indicating no available moves
      }
    }
  }
}
