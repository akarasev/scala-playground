package example

import scala.collection.Searching.{Found, search}
import scala.collection.mutable.ArrayBuffer

/**
  * <h3>Binary Search: Ice Cream Parlor</h3>
  * <p>
  *   Each time Sunny and Johnny take a trip to the Ice Cream Parlor,
  *   they pool together money dollars for ice cream.
  *   On any given day, the parlor offers a line of n flavors.
  *   Each flavor, i, is numbered sequentially with a unique
  *   ID number from 1 to n and has a cost, cost<sub>i</sub>,
  *   associated with it.
  * </p>
  * <p>
  *   Given the value of money and the cost of each flavor for t trips
  *   to the Ice Cream Parlor, help Sunny and Johnny choose two distinct
  *   flavors such that they spend their entire pool of money during
  *   each visit.
  *   For each trip to the parlor, return the ID numbers for the two types of
  *   ice cream that Sunny and Johnny purchase as two space-separated integers.
  *   You must return the smaller ID first and the larger ID second.
  * </p>
  */
object BinarySearchIceCreamParlor {

  /**
    * Find flavors for a given amount of money into menu.
    *
    * @param money total available money.
    * @param prices menu items.
    * @return price 2-dimension tuple of menu item numbers.
    */
  def findFlavors(money: Int, prices: ArrayBuffer[Int]): (Int, Int) = {
    val pricesSorted = prices.clone.sorted

    var resultPrices = (-1, -1)

    var found = false
    for (firstFlavorIndex <- pricesSorted.indices if !found) {
      val complementPrice = money - pricesSorted(firstFlavorIndex)
      pricesSorted.drop(firstFlavorIndex).search(complementPrice) match {
        case Found(complementIndex) =>
          resultPrices = getResultPrices(prices, pricesSorted(firstFlavorIndex), pricesSorted(complementIndex))
          found = true
        case _ =>
      }
    }

    resultPrices
  }

  private def getResultPrices(prices: ArrayBuffer[Int], firstFlavorPrice: Int, secondFlavorPrice: Int): (Int, Int) = {
    val menuItemOne = findMenuItemIndex(prices, firstFlavorPrice)
    val menuItemTwo = findMenuItemIndex(prices, secondFlavorPrice, menuItemOne)
    (math.min(menuItemOne, menuItemTwo) + 1, math.max(menuItemOne, menuItemTwo) + 1)
  }

  private def findMenuItemIndex(menu: ArrayBuffer[Int], price: Int, skipIndex: Int = -1): Int = {
    var result = -1

    var found = false
    for (index <- menu.indices if !found) {
      if (index != skipIndex && menu(index) == price) {
        result = index
        found = true
      }
    }

    result
  }

}
