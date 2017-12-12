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

  /**
    * Find change combinations using recursion. Time complexity O(M^N)
    *
    * @param money amount of money.
    * @param coins list of coins' denominations
    * @return count of ways to make a change.
    */
  def makeChangeR(money: Int, coins: List[Int]): Int = {
    if (money > 0 && coins.nonEmpty) {
      makeChangeR(money - coins.head, coins) + makeChangeR(money, coins.tail)
    } else if (money == 0) {
      1
    } else {
      0
    }
  }

  /**
    * Find change combinations using dynamic programming. Time complexity O(MN) and additional space O(M)
    *
    * @param money amount of money.
    * @param coins list of coins' denominations
    * @return count of ways to make a change.
    */
  def makeChange(money: Int, coins: List[Int]): Int = {
    val combinations = Array.fill(money + 1)(0)
    combinations(0) = 1

    coins.foreach(coin => {
      for (amount <- 1 to money) {
        if (amount >= coin) {
          combinations(amount) += combinations(amount - coin)
        }
      }
    })

    combinations(money)
  }

}
