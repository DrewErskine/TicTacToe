// The entry point of the application
// -Orchestration of the game loop and handling game states.
//
// Author:
// @DrewErskine

object TicTacToe extends App {
  val board = new Board() // Initialize the game board
  val humanPlayer = Player('X', isAI = false) // Initialize the Player
  val aiPlayer = Player('O', isAI = true) // Initialize the Ai
  var currentPlayer = humanPlayer // Initializes whos turn
  var currentStatus = GameStatus.InProgress // Initialize the game status

  // switch the current player
  def switchPlayer(): Player =
    if (currentPlayer == humanPlayer) aiPlayer else humanPlayer

  // Main game loop
  while (currentStatus == GameStatus.InProgress) {

    board.displayBoard()

    var moveSuccessful = false
    // If the current player is not AI
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
    // If move is not successful, prompting for a valid move
    while (!moveSuccessful) {
      if (!currentPlayer.isAI) {
        println("Invalid move, try again.")
        println(
          s"Player ${currentPlayer.marker}, enter row and column numbers (1, 2, or 3):"
        )
      }
      moveSuccessful = currentPlayer.makeMove(board)
    }
    // Check if the current player has won
    if (board.checkWin) {
      currentStatus = GameStatus.Won
      println(s"Player ${currentPlayer.marker} wins!")
    } else if (board.isFull) { // Check if the board is full
      currentStatus = GameStatus.Draw
      println("The game is a draw.")
    } else {
      // switch to the next player
      currentPlayer = switchPlayer()
    }
  }

  board.displayBoard() // Final display of the board
}
