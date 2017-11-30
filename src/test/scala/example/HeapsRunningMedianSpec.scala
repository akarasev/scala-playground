package example

import org.scalatest.{FlatSpec, Matchers}

class HeapsRunningMedianSpec extends FlatSpec with Matchers {

  "For the input {12, 4, 5, 3, 8, 7} the output" should "be {12.0, 8.0, 5.0, 4.5, 5.0, 6.0}" in {
    HeapsRunningMedian.getMedians(List(12, 4, 5, 3, 8, 7)) shouldEqual List(12.0, 8.0, 5.0, 4.5, 5.0, 6.0)
  }

}
