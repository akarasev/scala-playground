package example

import org.scalatest.{FlatSpec, Matchers}

class CoinChangeSpec extends FlatSpec with Matchers {

  "Recursively: $4 with 1, 2 and 3 coins" should "have 4 ways" in {
    CoinChange.makeChangeR(4, List(1, 2, 3)) shouldBe 4
  }

  "Recursively: $10 with 2, 3, 5 and 6 coins" should "have 5 ways" in {
    CoinChange.makeChangeR(10, List(2, 3, 5, 6)) shouldBe 5
  }

  "Dynamic programming: $4 with 1, 2 and 3 coins" should "have 4 ways" in {
    CoinChange.makeChange(4, List(1, 2, 3)) shouldBe 4
  }

  "Dynamic programming: $10 with 2, 3, 5 and 6 coins" should "have 5 ways" in {
    CoinChange.makeChange(10, List(2, 3, 5, 6)) shouldBe 5
  }
}
