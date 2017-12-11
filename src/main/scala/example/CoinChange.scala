package example

/**
  * <h3>Recursion and dynamic programming</h3>
  * <p>
  *   Given a number of dollars, n, and a list of dollar values for m distinct
  *   coins, find and return the number of different ways you can make change
  *   for n dollars if each coin is available in an infinite quantity.
  * </p>
  */
object CoinChange {

  def countR(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      1
    } else if (money > 0 && coins.nonEmpty) {
      countR(money - coins.head, coins) + countR(money, coins.tail)
    } else {
      0
    }
  }

  def count(money: Int, coins: List[Int]): Int = {
    ???
  }

}
