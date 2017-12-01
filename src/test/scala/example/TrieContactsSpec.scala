package example

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TrieContactsSpec extends FlatSpec with Matchers with BeforeAndAfter {

  before {
    TrieContacts.add("some")
    TrieContacts.add("something")
  }

  "The word 'some'" should "have two matches" in {
    TrieContacts.find("some") shouldEqual 2
  }

  "The word 'somebody'" should "have no matches" in {
    TrieContacts.find("somebody") shouldEqual 0
  }
}
