package example

import example.SortingOrdered.Player
import org.scalatest.{FlatSpec, Matchers}

class SortingOrderedSpec extends FlatSpec with Matchers {

  it should "be sorted in order of decreasing score and alphabetically by name" in {
    val array = Array(
      Player("ammy", 100),
      Player("david", 100),
      Player("heraldo", 50),
      Player("aakansha", 75),
      Player("aleksa", 150)
    )

    val players = SortingOrdered.sort(array)

    players shouldEqual Array(
      Player("aleksa", 150),
      Player("ammy", 100),
      Player("david", 100),
      Player("aakansha", 75),
      Player("heraldo", 50)
    )
  }

}
