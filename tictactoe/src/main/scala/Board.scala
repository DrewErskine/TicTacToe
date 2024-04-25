// Definition of a class named Board
// Handling the board state, including displaying the board, placing marks, and checking for game end conditions.
//
// Author:
// @DrewErskine

class Board {
  // Initialize a 3x3 grid filled with '-' characters
  val grid: Array[Array[Char]] = Array.fill(3, 3)('-') // 3x3 grid initialized with '-'

  // Method to place a mark (X or O) at a given row and column
  def placeMark(row: Int, col: Int, player: Char): Boolean = {
    // Check if cell is empty
    if (grid(row)(col) == '-') {
      // If empty, place the player's mark in the cell and return true
      grid(row)(col) = player
      true
    } else {
      // If not empty, return false
      false
    }
  }

  // Method to check if player has won
  def checkWin: Boolean = {
    // Check rows for a win
    val rows = grid.exists(row => row.distinct.length == 1 && row(0) != '-')
    // chekc cols For a win
    val cols = (0 until 3).exists(col => grid.map(row => row(col)).distinct.length == 1 && grid(0)(col) != '-')
    // Check diagonals
    val diag1 = grid(0)(0) == grid(1)(1) && grid(1)(1) == grid(2)(2) && grid(0)(0) != '-'
    val diag2 = grid(0)(2) == grid(1)(1) && grid(1)(1) == grid(2)(0) && grid(0)(2) != '-'

    // Return true if any of the conditions for winning are met
    rows || cols || diag1 || diag2
  }

  // Method to check if the board is full
  def isFull: Boolean = {
    !grid.flatten.contains('-')
  }

  // Method to check if a spot on the board is empty
  def isSpotAvailable(row: Int, col: Int): Boolean = {
    grid(row)(col) == '-'  // Check if the specified cell is empty
  }

  // Method to display the current state of the board
  def displayBoard(): Unit = {
    // Current board state
    println("\nCurrent Board:\n")
    println("    1   2   3")
    println("   -----------")
    for (i <- grid.indices) {
      print(s"${i + 1} | ")
      for (j <- grid(i).indices) {
        print(s"${grid(i)(j)} | ")
      }
      println("\n   -----------")
    }
  }
}
