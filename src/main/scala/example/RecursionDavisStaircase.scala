package example

/**
  * <h3>Recursion: Davis' Staircase</h3>
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
object RecursionDavisStaircase {

  /**
    * Count the number of ways Davis can climb on the top of staircase.
    *
    * @param steps the number of staircases.
    * @return the number of ways to climb.
    */
  def countWays(steps: Int): Int = {
    countWaysR(steps, Array.fill(steps + 1)(0))
  }

  def countWaysR(steps: Int, memo: Array[Int]): Int = steps match {
    case i if i < 0 => 0
    case 0 => 1
    case n =>
      if (memo(n) == 0) {
        memo(n) = countWaysR(n - 1, memo) + countWaysR(n - 2, memo) + countWaysR(n - 3, memo)
      }
      memo(n)
  }
}
