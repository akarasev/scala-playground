package example

/**
  * <h3>Recursion: Fibonacci Numbers</h3>
  * <p>
  *   The Fibonacci sequence begins with fibonacci(0) = 0
  *   and fibonacci(1) = 1 as its respective first and second terms.
  *   After these first two elements, each subsequent element is equal
  *   to the sum of the previous two elements.
  * </p>
  * <p>
  *   Task is, Given n, complete the fibonacci function so it returns fibonacci(n).
  * </p>
  * <p>
  *   The task is also a sample of recursion (not the tail now) and pattern matching.
  * </p>
  */
object RecursionFibonacciSequence {

  /**
    * Calculate fibonacci number at given position.
    *
    * @param number position.
    * @return fibonacci number.
    */
  def calc(number: Int): Int = number match {
    case 0 | 1 => number
    case n => calc(n - 1) + calc(n - 2)
  }

}
