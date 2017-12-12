package example

import org.scalatest.{FlatSpec, Matchers}

class FoldingSpec extends FlatSpec with Matchers {

  "Into list {1, -1} the answer" should "be -1 and 1" in {
    Folding.findMaxNegativeAndMinPositive(List(1, -1)) shouldBe (-1, 1)
  }

  "Into list {1, 3, 0, -9, 6, 2, -3, -2, 5} the answer" should "be -2 and 1" in {
    Folding.findMaxNegativeAndMinPositive(List(1, 3, 0, -9, 6, 2, -3, -2, 5)) shouldBe (-2, 1)
  }

}
