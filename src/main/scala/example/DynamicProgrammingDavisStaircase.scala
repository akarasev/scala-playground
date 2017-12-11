package example

/**
  * <h3>Dynamic programming: Davis' Staircase</h3>
  * <p>
  *   Davis has  staircases in his house and he likes to climb each
  *   staircase 1, 2, or 3 steps at a time.
  *   Being a very precocious child, he wonders how many ways
  *   there are to reach the top of the staircase.
  * </p>
  * <p>
  *   Given the respective heights for each of the s staircases in his house,
  *   find and print the number of ways he can climb each staircase on a new line.
  * </p>
  */
object DynamicProgrammingDavisStaircase {

  /**
    * Count the number of ways Davis can climb on the top of staircase.
    *
    * @param steps the number of staircases.
    * @return the number of ways to climb.
    */
  def countWays(steps: Int): Int = steps match {
    case i if i < 0 => 0
    case 0 | 1 => 1
    case n =>
      val ways = Array(1, 1, 2)

      for (i <- 3 to n) {
        val count = ways(0) + ways(1) + ways(2)
        ways(0) = ways(1)
        ways(1) = ways(2)
        ways(2) = count
      }

      ways(2)
  }
}
