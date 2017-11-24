package example

/**
  * <h3>Linked lists: detect cycles</h3>
  * <p>
  *   A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
  * </p>
  */
object CycleDetector extends App {

  /**
    * Simple linked list item.
    *
    * @param value sample node's data.
    */
  class Node(value: Int) {
    var data: Int = value
    var next: Node = null
  }

  /**
    * Auxiliary class (for the sample only)
    */
  class SimpleLinkedList {
    var head: Node = null

    def prepend(value: Int) = {
      val node = new Node(value)
      node.next = head
      head = node
    }

    def findNode(data: Int): Option[Node] = {
      var result: Option[Node] = None

      var node: Node = head

      while (node.next != null) {
        if (node.data == data) {
          result = Option(node)
        }
        node = node.next
      }

      if (node.data == data) {
        result = Option(node)
      }

      result
    }

    def connectNodes(nodeFrom: Node, nodeTo: Node): Unit = {
      nodeFrom.next = nodeTo
    }
  }

  /**
    * Return a boolean denoting whether or not there is a cycle in the list.
    *
    * @param head list's head.
    * @return ff there is a cycle, return true; otherwise, return false.
    */
  def hasCycle(head: Node): Boolean = {
    var cycleDetected: Boolean = false

    if (head == null) {
      cycleDetected = false
    } else {
      var slow = head
      var fast = head

      while (fast.next != null && !cycleDetected) {
        slow = slow.next

        if (fast.next != null) {
          fast = fast.next.next
        }

        if (fast.next == slow) {
          cycleDetected = true
        }
      }
    }

    cycleDetected
  }

}
