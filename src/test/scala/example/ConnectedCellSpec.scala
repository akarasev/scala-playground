package example

import org.scalatest.{FlatSpec, Matchers}

class ConnectedCellSpec extends FlatSpec with Matchers {

  it should "have largest region with 5 connected cells" in {
    val grid = Array.ofDim[Int](4, 4)
    grid(0) = Array(1, 1, 0, 0)
    grid(1) = Array(0, 1, 1, 0)
    grid(2) = Array(0, 0, 1, 0)
    grid(3) = Array(1, 0, 0, 0)

    ConnectedCell.getLargestRegionSize(grid) shouldBe 5
  }

  it should "have no regions" in {
    val grid = Array.ofDim[Int](4, 4)
    grid(0) = Array(0, 0, 0, 0)
    grid(1) = Array(0, 0, 0, 0)
    grid(2) = Array(0, 0, 0, 0)
    grid(3) = Array(0, 0, 0, 0)

    ConnectedCell.getLargestRegionSize(grid) shouldBe 0
  }

  it should "have largest region with 3 connected cells" in {
    val grid = Array.ofDim[Int](4, 4)
    grid(0) = Array(1, 0, 0, 1)
    grid(1) = Array(1, 0, 1, 0)
    grid(2) = Array(0, 0, 1, 0)
    grid(3) = Array(1, 0, 0, 0)

    ConnectedCell.getLargestRegionSize(grid) shouldBe 3
  }

}
