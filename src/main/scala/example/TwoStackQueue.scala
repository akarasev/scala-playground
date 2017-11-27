package example

/**
  * <h3>Queues: A Tale of Two Stacks</h3>
  * <p>
  *   A queue is an abstract data type that maintains the order in which
  *   elements were added to it, allowing the oldest elements to be removed
  *   from the front and new elements to be added to the rear.
  *   This is called a First-In-First-Out (FIFO) data structure because the
  *   first element added to the queue
  *   (i.e., the one that has been waiting the longest) is always the first one
  *   to be removed.
  * </p>
  * <p>
  *   A basic queue has the following operations:
  * </p>
  * <ul>
  *   <li>Enqueue: add a new element to the end of the queue.</li>
  *   <li>Dequeue: remove the element from the front of the queue and return it.</li>
  * </ul>
  *
  * <p>
  *   This is an implementation of a queue using two stacks.
  * </p>
  */
object TwoStackQueue {

  var stackOne: List[Int] = List()
  var stackTwo: List[Int] = List()

  /**
    * Enqueue element x into the end of the queue.
    *
    * @param value the element to enqueue.
    */
  def enqueue(value: Int): Unit = {
    stackOne = value :: stackOne
  }

  /**
    * Dequeue the element at the front of the queue.
    *
    * @return element at the front of the queue.
    */
  def deque(): Int = {
    if (stackTwo.isEmpty) {
      while (stackOne.nonEmpty) {
        stackTwo = stackOne.head :: stackTwo
        stackOne = stackOne.tail
      }
    }

    val head = stackTwo.head
    stackTwo = stackTwo.tail
    head
  }

  /**
    * Peek the element at the front of the queue.
    *
    * @return return the element at the front of the queue, but keep it in the queue.
    */
  def peek(): Int = {
    if (stackTwo.isEmpty) {
      while (stackOne.nonEmpty) {
        stackTwo = stackOne.head :: stackTwo
        stackOne = stackOne.tail
      }
    }

    stackTwo.head
  }

  /**
    * Check if the queue is empty.
    *
    * @return true, if the queue is empty; otherwise, return false.
    */
  def isEmpty(): Boolean = {
    stackOne.isEmpty && stackTwo.isEmpty
  }
}
