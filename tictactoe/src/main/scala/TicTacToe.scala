
object TicTacToe extends App {
  val board = new Board()
  val humanPlayer = Player('X', isAI = false)
  val aiPlayer = Player('O', isAI = true)
  var currentPlayer = humanPlayer
  var currentStatus = GameStatus.InProgress

  def switchPlayer(): Player = if (currentPlayer == humanPlayer) aiPlayer else humanPlayer

  while (currentStatus == GameStatus.InProgress) {
    board.displayBoard()
    var moveSuccessful = currentPlayer.makeMove(board)

    while (!moveSuccessful) {
      if (!currentPlayer.isAI) {
        println("Invalid move, try again.")
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
