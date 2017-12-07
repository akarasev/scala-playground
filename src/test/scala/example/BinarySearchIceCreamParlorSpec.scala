package example

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ArrayBuffer

class BinarySearchIceCreamParlorSpec extends FlatSpec with Matchers {

  "With $4 and price list {1, 4, 5, 3, 2} they" should "afford options 1 and 4" in {
    val prices = BinarySearchIceCreamParlor.findFlavors(4, ArrayBuffer(1, 4, 5, 3, 2))
    prices shouldEqual (1, 4)
  }

  "With $4 and price list {2, 2, 4, 3} they" should "afford options 1 and 2" in {
    val prices = BinarySearchIceCreamParlor.findFlavors(4, ArrayBuffer(2, 2, 4, 3))
    prices shouldEqual (1, 2)
  }

}
