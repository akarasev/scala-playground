package example

/**
  * <h3>Trees: Is This a Binary Search Tree?</h3>
  * <p>
  *   A binary search tree to be a binary tree with the following ordering
  *   properties:
  * </p>
  * <ul>
  *   <li>
  *     The data value of every node in a node's left subtree is less than
  *     the data value of that node.
  *   </li>
  *   <li>
  *     The data value of every node in a node's right subtree is greater
  *     than the data value of that node.
  *   </li>
  * </ul>
  * <p>
  *   Given the root node of a binary tree,
  *   it is needed to determine if it's also a binary search tree
  * </p>
  *
  * <h3>Constraints</h3>
  * <ul>
  *   <li>0 &le; data &le; 10<sup>4</sup>
  * </ul>
  */
object BinaryTreeChecker {

  case class Node(data: Int, left: Node, right: Node)

  case object Node {
    def apply(data: Int) = new Node(data, null, null)
  }

  /**
    * Check whether the tree with given root node is Binary Search Tree.
    *
    * @param root root of the tree.
    * @return true, is the tree is Binary Search Tree; false, otherwise.
    */
  def isBinarySearchTree(root: Node): Boolean = {
    def isBinarySearchTree(node: Node, lowBound: Int, hiBound: Int): Boolean = {
      if (node == null) {
        return true
      }

      if (node.data < lowBound || node.data > hiBound) {
        return false
      }

      (isBinarySearchTree(node.left, lowBound, node.data - 1)
        && isBinarySearchTree(node.right, node.data + 1, hiBound))
    }

    isBinarySearchTree(root: Node, 0, 10000)
  }

}
