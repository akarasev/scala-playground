package example

import org.scalatest.{FlatSpec, Matchers}

class BinaryTreeCheckerSpec extends FlatSpec with Matchers {

  "Tree" should "be binary" in {
    BinaryTreeChecker.isBinarySearchTree(???) shouldBe true
  }

  "Tree" should "not be binary" in {
    BinaryTreeChecker.isBinarySearchTree(???) shouldBe false
  }

}
