package example

import example.BinaryTreeChecker.Node
import org.scalatest.{FlatSpec, Matchers}

class BinaryTreeCheckerSpec extends FlatSpec with Matchers {

  "Sample binary tree" should "be binary search tree" in {
    val tree =
      Node(4,
        Node(2,
          Node(1), Node(3)),
        Node(6,
          Node(5), Node(7)))

    BinaryTreeChecker.isBinarySearchTree(tree) shouldBe true
  }

  "Sample binary tree" should "not be binary search tree" in {
    val tree =
      Node(44,
        Node(2,
          Node(1), Node(3)),
        Node(6,
          Node(5), Node(7)))

    BinaryTreeChecker.isBinarySearchTree(tree) shouldBe false
  }

}
