package example

import org.scalatest.{FlatSpec, Matchers}

class AnagramSpec extends FlatSpec with Matchers {

  "from strings 'cde' and 'abc'" should "be deleted 4 characters" in {
    Anagram.calcDeletions("cde", "abc") shouldEqual 4
  }

}
