object TicTacToe extends App {
  val board = new Board()
  val humanPlayer = Player('X', isAI = false)
  val aiPlayer = Player('O', isAI = true)
  var currentPlayer = humanPlayer
  var currentStatus = GameStatus.InProgress

  def switchPlayer(): Player =
    if (currentPlayer == humanPlayer) aiPlayer else humanPlayer

  while (currentStatus == GameStatus.InProgress) {

    board.displayBoard()

    var moveSuccessful = false
    if (!currentPlayer.isAI) {
      println(
        s"\nPlayer ${currentPlayer.marker}, enter row and column numbers (1, 2, or 3):"
      )
      val row =
        scala.io.StdIn
          .readInt() - 1 // Subtract 1 to match internal zero-based index
      val col =
        scala.io.StdIn
          .readInt() - 1 // Subtract 1 to match internal zero-based index
      moveSuccessful = board.placeMark(row, col, currentPlayer.marker)
    }
    while (!moveSuccessful) {
      if (!currentPlayer.isAI) {
        println("Invalid move, try again.")
        println(
          s"Player ${currentPlayer.marker}, enter row and column numbers (1, 2, or 3):"
        )
      }
      moveSuccessful = currentPlayer.makeMove(board)
    }

    if (board.checkWin) {
      currentStatus = GameStatus.Won
      println(s"Player ${currentPlayer.marker} wins!")
    } else if (board.isFull) {
      currentStatus = GameStatus.Draw
      println("The game is a draw.")
    } else {
      currentPlayer = switchPlayer()
    }
  }

  board.displayBoard() // Final display of the board
}
