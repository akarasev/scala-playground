package example

import org.scalatest.{FlatSpec, Matchers}

class BitManipulationSpec extends FlatSpec with Matchers {

  "For {1, 1, 2} the unique element" should "be 2" in {
    BitManipulation.findUnique(List(1, 1, 2)) shouldBe 2
  }

  "For {0, 0, 1, 3, 1} the unique element" should "be 3" in {
    BitManipulation.findUnique(List(0, 0, 1, 3, 1)) shouldBe 3
  }

}
