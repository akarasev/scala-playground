package example

/**
  * <h3>Bubble sort</h3>
  * <p>
  *   The sample demonstrates bubble sort, working with arrays and loops.
  * </p>
  */
object BubbleSort {

  def sort(array: Array[Int]): Unit = {
    for (i <- array.indices) {
      for (j <- 0 until array.length - 1 - i) {
        if (array(j) > array(j + 1)) {
          val tmp = array(j)
          array(j) = array(j + 1)
          array(j + 1) = tmp
        }
      }
    }
  }

}
