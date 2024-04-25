// Definition of a case class named Player
// -player behavior, including making moves.
//
// Author:
// @DrewErskine

case class Player(marker: Char, isAI: Boolean = false) {
  // Method to make a move
  def makeMove(board: Board): Boolean = {
    // Check if AI
    if (!isAI) {
      // If not AI, prompt the player for row and column
      println(s"Player $marker, enter Row (1, 2, or 3):")
      val row = scala.io.StdIn.readInt() // Read row
      println(s"Player $marker, enter Column (1, 2, or 3):")
      val col = scala.io.StdIn.readInt() // Read column
      board.placeMark(row, col, marker) // Place mark on board
    } else {
      // If AI, find available move *spot*
      val availableMoves = for {
        row <- 0 to 2
        col <- 0 to 2
        if board.isSpotAvailable(row, col) // Check if spot is available
      } yield (row, col)

      // If theres a spot to be played by the ai
      if (availableMoves.nonEmpty) {
        // randomly select one
        val (row, col) = availableMoves(scala.util.Random.nextInt(availableMoves.length))
        board.placeMark(row, col, marker) // Place the AI's marker
        println(s"AI $marker placed a mark at ($row, $col)") // Print - AI's move
        true // successful move
      } else {
        false // unlucky no move or invalid move or other move problem issues
      }
    }
  }
}
