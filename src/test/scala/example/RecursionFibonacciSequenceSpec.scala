package example

import org.scalatest.{FlatSpec, Matchers}

class RecursionFibonacciSequenceSpec extends FlatSpec with Matchers {

  "The third fibonacci number" should "be 2" in {
    RecursionFibonacciSequence.calc(3) shouldBe 2
  }

  "The fourth fibonacci number" should "be 3" in {
    RecursionFibonacciSequence.calc(4) shouldBe 3
  }

  "The fifth fibonacci number" should "be 5" in {
    RecursionFibonacciSequence.calc(5) shouldBe 5
  }

  "The sixth fibonacci number" should "be 8" in {
    RecursionFibonacciSequence.calc(6) shouldBe 8
  }
}
