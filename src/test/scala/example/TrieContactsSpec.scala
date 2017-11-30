package example

import org.scalatest.{FlatSpec, Matchers}

class TrieContactsSpec extends FlatSpec with Matchers {

  "After adding 'some' and 'something' the output for 'some' and 'somebody'" should "be 2 and 0" in {
    TrieContacts.add("some")
    TrieContacts.add("something")
    TrieContacts.find("some") shouldEqual 2
    TrieContacts.find("somebody") shouldEqual 0
  }
}
