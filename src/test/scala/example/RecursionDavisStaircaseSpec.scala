package example

import org.scalatest.{FlatSpec, Matchers}

class RecursionDavisStaircaseSpec extends FlatSpec with Matchers {

  "For staircase with 3 steps and height of 1" should "only 1 way" in {
    RecursionDavisStaircase.calc(3) shouldBe 1
  }

  "For staircase with 3 steps it" should "only 1 way" in {
    RecursionDavisStaircase.calc(3) shouldBe 1
  }
}
