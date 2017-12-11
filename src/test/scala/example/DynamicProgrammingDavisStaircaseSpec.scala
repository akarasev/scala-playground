package example

import org.scalatest.{FlatSpec, Matchers}

class DynamicProgrammingDavisStaircaseSpec extends FlatSpec with Matchers {

  "For staircase with 1 steps" should "have only 1 way" in {
    DynamicProgrammingDavisStaircase.countWays(1) shouldBe 1
  }

  "For staircase with 3 steps it" should "have 3 ways" in {
    DynamicProgrammingDavisStaircase.countWays(3) shouldBe 4
  }

  "For staircase with 7 steps it" should "have 44 ways" in {
    DynamicProgrammingDavisStaircase.countWays(7) shouldBe 44
  }

}
