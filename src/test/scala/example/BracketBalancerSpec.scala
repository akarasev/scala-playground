package example

import org.scalatest.{FlatSpec, Matchers}

class BracketBalancerSpec extends FlatSpec with Matchers {

  "Brackets {[()]}" should "be balanced" in {
    BracketBalancer.isBalanced("{[()]}") shouldBe true
  }

  "Brackets {[(])}" should "be unbalanced" in {
    BracketBalancer.isBalanced("{[(])}") shouldBe false
  }

  "Brackets {{[[(())]]}}" should "be balanced" in {
    BracketBalancer.isBalanced("{{[[(())]]}}") shouldBe true
  }

  "Brackets ((()))" should "be balanced" in {
    BracketBalancer.isBalancedRecursion("((()))") shouldBe true
  }

  "Brackets ((()" should "be unbalanced" in {
    BracketBalancer.isBalancedRecursion("((()") shouldBe false
  }
}
