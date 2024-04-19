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

  def displayBoard(): Unit = {
    println("    0   1   2")
    println("  -------------")
    for (row <- grid.indices) {
      print(s"${row} |")
      for (col <- grid(row).indices) {
        print(s" ${grid(row)(col)} |")
      }
      println("\n  -------------")
    }
  }
}
