package example

import org.scalatest.{FlatSpec, Matchers}

class MergeSortSpec extends FlatSpec with Matchers {

  "Array {7, 3, 4, 0, 8, 9, 2, 5, 1, 6}" should "be sorted" in {
    val items = List(7, 3, 4, 0, 8, 9, 2, 5, 1, 6)

    MergeSort.sort(items) shouldEqual List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  }

}
