package example

import org.scalatest.{FlatSpec, Matchers}

class RecursionDavisStaircaseSpec extends FlatSpec with Matchers {

  "For staircase with 1 steps" should "have only 1 way" in {
    RecursionDavisStaircase.countWays(1) shouldBe 1
  }

  "For staircase with 3 steps it" should "have 3 ways" in {
    RecursionDavisStaircase.countWays(3) shouldBe 4
  }

  "For staircase with 7 steps it" should "have 44 ways" in {
    RecursionDavisStaircase.countWays(7) shouldBe 44
  }
}
