package example

/**
  * <h3>Breadth First Search: Shortest Reach in a Graph</h3>
  * <p>
  *   Consider an undirected graph consisting of n nodes where each node is
  *   labeled from 1 to n and the edge between any two nodes is always of
  *   length 6.
  *   We define node s to be the starting position for a BFS.
  * </p>
  * <p>
  *   Given some starting node, s, perform each query by calculating the
  *   shortest distance from starting node s to all the other nodes
  *   in the graph.
  *   Then return a sequence of n - 1 space-separated integers listing
  *   node s's shortest distance to each of the n - 1 other nodes
  *   (ordered sequentially by node number);
  *   if s is disconnected from a node, print -1 as the distance to that node.
  * </p>
  *
  * @param n node count.
  */
class ShortestReachGraph(val n: Int) {

  private var nodeLookup = Map[Int, Node]()
  (0 until n).foreach(index => nodeLookup += (index -> new Node(index)))

  private class Node(val index: Int) {
    var neighbors: List[Int] = List()
  }

  /**
    * Connect two nodes of the undirected graph.
    *
    * @param nodeNumberOne node number.
    * @param nodeNumberTwo other node number.
    */
  def connectNodes(nodeNumberOne: Int, nodeNumberTwo: Int): Unit = {
    require(nodeLookup.contains(nodeNumberOne - 1), s"Node $nodeNumberOne not found")
    require(nodeLookup.contains(nodeNumberTwo - 1), s"Node $nodeNumberTwo not found")

    val nodeOne = nodeLookup(nodeNumberOne - 1)
    val nodeTwo = nodeLookup(nodeNumberTwo - 1)

    nodeOne.neighbors = nodeTwo.index :: nodeOne.neighbors
    nodeTwo.neighbors = nodeOne.index :: nodeTwo.neighbors
  }

  /**
    * Find distances to all other nodes of the graph.
    *
    * @param s starting node.
    * @return ordered sequence of distances to all other nodes.
    */
  def getDistances(s: Int): Seq[Int] = {
    val startIndex = s - 1
    require(nodeLookup.contains(startIndex), "Start node not found")

    val startNode = nodeLookup(startIndex)

    val distances = Array.fill(n)(-1)
    distances(startIndex) = 0

    var queue = List(startIndex)

    while (queue.nonEmpty) {
      val node = nodeLookup(queue.head)
      queue = queue.tail

      node.neighbors.foreach(neighbor => {
        if (distances(neighbor) == -1) {
          distances(neighbor) = distances(node.index) + 6
          queue = neighbor :: queue
        }
      })
    }

    distances.filterNot(_ == 0)
  }

}

object ShortestReachGraph {
  def apply(n: Int): ShortestReachGraph = new ShortestReachGraph(n)
}
