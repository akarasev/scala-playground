package example

/**
  * <h3>Depth First Search: Connected Cell in a Grid</h3>
  * <p>
  *   Consider a matrix with n rows and m columns, where each cell contains
  *   either a 0 or a 1 and any cell containing a 1 is called a filled cell.
  *   Two cells are said to be connected if they are adjacent to each other
  *   horizontally, vertically, or diagonally
  * </p>
  * <p>
  *   If one or more filled cells are also connected, they form a region.
  *   Note that each cell in a region is connected to at least one other cell
  *   in the region but is not necessarily directly connected to all the other
  *   cells in the region.
  * </p>
  * <p>
  *   Given an n x m matrix, find and return the number of cells in the largest
  *   region in the matrix.
  *   Note that there may be more than one region in the matrix.
  * </p>
  */
object ConnectedCell {

  /**
    * Find largest region size.
    *
    * @param grid matrix of 0 and 1.
    * @return integer.
    */
  def getLargestRegionSize(grid: Array[Array[Int]]): Int = {
    var result = 0

    for (row <- grid.indices) {
      for (col <- grid.indices) {
        if (grid(row)(col) == 1) {
          val size = computeRegionSize(grid, row, col)
          result = math.max(result, size)
        }
      }
    }

    result
  }

  private def computeRegionSize(grid: Array[Array[Int]], row: Int, col: Int): Int = {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid(row).length) {
      return 0
    }

    if (grid(row)(col) == 0) {
      return 0
    }

    var size = 1
    grid(row)(col) = 0

    for (r <- row - 1 to row + 1) {
      for (c <- col - 1 to col + 1) {
        if (!(r == row && c == col)) {
          size += computeRegionSize(grid, r, c)
        }
      }
    }

    size
  }

}
