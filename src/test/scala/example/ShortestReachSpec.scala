package example

import org.scalatest.{FlatSpec, Matchers}

class ShortestReachSpec extends FlatSpec with Matchers {

  "Graph 1 <-> 2; 1 <-> 3; alone 4 with start at 1" should "have {6, 6, -1} distances" in {
    val graph = ShortestReachGraph(4)

    graph.connectNodes(1, 2)
    graph.connectNodes(1, 3)

    graph.getDistances(1) shouldBe Seq(6, 6, -1)
  }

  "Graph 3 <-> 1; 2 <-> 3 with start at 2" should "have {-1, 6} distances" in {
    val graph = ShortestReachGraph(3)

    graph.connectNodes(2, 3)

    graph.getDistances(2) shouldBe Seq(-1, 6)
  }

  "Graph 1 <-> 2; 1 <-> 3; 2 <-> 5; alone 4 with start at 1" should "have {6, 6, -1, 12} distances" in {
    val graph = ShortestReachGraph(5)

    graph.connectNodes(1, 2)
    graph.connectNodes(1, 3)
    graph.connectNodes(2, 5)

    graph.getDistances(1) shouldBe Seq(6, 6, -1, 12)
  }

}
