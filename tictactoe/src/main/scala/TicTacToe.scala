object Tictactoe extends App {
  val board = new Board()
  val player1 = Player('X')
  val player2 = Player('O')
  var currentPlayer = player1
  var currentStatus = GameStatus.InProgress

  def switchPlayer(): Player = if (currentPlayer == player1) player2 else player1

  while (currentStatus == GameStatus.InProgress) {
    board.displayBoard()
    var moveSuccessful = currentPlayer.makeMove(board)

    while (!moveSuccessful) {
      println("Invalid move, try again.")
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
