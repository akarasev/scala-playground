package example

/**
  * <h3>Reduction operations: fold</h3>
  * <p>
  *   Given list of integers, both negative and positive, find and return
  *   max negative and min positive integers in on pass.
  * </p>
  */
object Folding {

  /**
    * Find a pair of integers: max negative and min positive
    *
    * @param list of all integers.
    * @return tuple.
    */
  def findMaxNegativeAndMinPositive(list: List[Int]): (Int, Int) = {
    list.foldLeft((Int.MinValue, Int.MaxValue)) { case ((maxNegative, minPositive), value) =>
      if (value < 0) {
        (math.max(maxNegative, value), minPositive)
      } else if (value > 0) {
        (maxNegative, math.min(minPositive, value))
      } else {
        (maxNegative, minPositive)
      }
    }
  }
}
