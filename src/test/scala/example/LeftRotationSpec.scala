package example

import org.scalatest.{FlatSpec, Matchers}

class LeftRotationSpec extends FlatSpec with Matchers {

  "The array [1, 2, 3, 4, 5] rotated 2 times" should "become [3, 4, 5, 1, 2]" in {
    LeftRotation.rotate(Array(1, 2, 3, 4, 5), 2) shouldEqual Array(3, 4, 5, 1, 2)
  }

  "The array [1, 2, 3, 4, 5] rotated 4 times" should "become [5, 1, 2, 3, 4]" in {
    LeftRotation.rotate(Array(1, 2, 3, 4, 5), 4) shouldEqual Array(5, 1, 2, 3, 4)
  }

  an [IllegalArgumentException] should be thrownBy LeftRotation.rotate(Array(1, 2, 3), 4)
}
