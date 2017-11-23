package example

import org.scalatest.{FlatSpec, Matchers}

class RansomNoteSpec extends FlatSpec with Matchers {

  "The ransome note" should "be doable" in {
    val magazineText = "give me one grand today night"
    val noteText = "give me one grand today"
    RansomNote.isDoable(magazineText, noteText) shouldBe true
  }

  "The ransome note" should "not be doable" in {
    val magazineText = "give me two grand today night"
    val noteText = "give me one grand today"
    RansomNote.isDoable(magazineText, noteText) shouldBe false
  }


}
