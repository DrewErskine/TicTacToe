
class Board {
  val grid: Array[Array[Char]] = Array.fill(3, 3)('-') // 3x3 grid initialized with '-'

  def placeMark(row: Int, col: Int, player: Char): Boolean = {
    if (grid(row)(col) == '-') {
      grid(row)(col) = player
      true
    } else {
      false
    }
  }

  def checkWin: Boolean = {
    val rows = grid.exists(row => row.distinct.length == 1 && row(0) != '-')
    val cols = (0 until 3).exists(col => grid.map(row => row(col)).distinct.length == 1 && grid(0)(col) != '-')
    val diag1 = grid(0)(0) == grid(1)(1) && grid(1)(1) == grid(2)(2) && grid(0)(0) != '-'
    val diag2 = grid(0)(2) == grid(1)(1) && grid(1)(1) == grid(2)(0) && grid(0)(2) != '-'

    rows || cols || diag1 || diag2
  }

  def isFull: Boolean = {
    !grid.flatten.contains('-')
  }

  def isSpotAvailable(row: Int, col: Int): Boolean = {
    grid(row)(col) == '-'  // Corrected reference to the grid array
  }

  def displayBoard(): Unit = {
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
