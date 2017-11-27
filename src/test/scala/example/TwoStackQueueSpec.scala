package example

import org.scalatest.{FlatSpec, Matchers}

class TwoStackQueueSpec extends FlatSpec with Matchers {

  "Operation set" should "return 14 twice and to be empty in the end" in {
    TwoStackQueue.enqueue(42)
    TwoStackQueue.deque()
    TwoStackQueue.enqueue(14)
    TwoStackQueue.peek() shouldBe 14
    TwoStackQueue.enqueue(28)
    TwoStackQueue.peek() shouldBe 14
    TwoStackQueue.enqueue(60)
    TwoStackQueue.enqueue(78)
    TwoStackQueue.deque()
    TwoStackQueue.deque()
    TwoStackQueue.deque()
    TwoStackQueue.deque()
    TwoStackQueue.isEmpty() shouldBe true
  }

}
