package example

import example.CycleDetector.SimpleLinkedList
import org.scalatest.{FlatSpec, Matchers}

class CycleDetectorSpec extends FlatSpec with Matchers {

  "Empty linked list" should "have no cycles" in {
    CycleDetector.hasCycle(null) shouldEqual false
  }

  "Linked list 1 -> 2 -> 3 -> 4 -> 5" should "have no cycles" in {
    val list = new SimpleLinkedList
    list.prepend(5)
    list.prepend(4)
    list.prepend(3)
    list.prepend(2)
    list.prepend(1)

    CycleDetector.hasCycle(list.head) shouldEqual false
  }

  "Linked list 1 -> 2 -> 3 -> 2" should "have a detected cycle" in {
    val list = new SimpleLinkedList
    list.prepend(3)
    list.prepend(2)
    list.prepend(1)

    val nodeThree = list.findNode(3)
    val nodeTwo = list.findNode(2)

    for {
      nodeFrom <- nodeThree
      nodeTo <- nodeTwo
    } yield {
      list.connectNodes(nodeFrom, nodeTo)
    }

    CycleDetector.hasCycle(list.head) shouldEqual true
  }

}
