package example

/**
  * <h3>Hash Tables: Ransom Note</h3>
  * <p>
  *   A kidnapper wrote a ransom note but is worried it will be traced back to him.
  *   He found a magazine and wants to know if he can cut out whole words from it
  *   and use them to create an untraceable replica of his ransom note.
  *   The words in his note are case-sensitive and he must use whole words available in the magazine,
  *   meaning he cannot use substrings or concatenation to create the words he needs.
  * </p>
  *
  * <h3>Constraints</h3>
  * <ul>
  *   <li>1 &le; m,n &le; 30000</li>
  *   <li>1 &le; length of any word &le; 5</li>
  *   <li>Each word consists of English alphabetic letters.</li>
  *   <li>The words in the note and magazine are case-sensitive.</li>
  * </ul>
  */
object RansomNote extends App {

  /**
    * Given the words in the magazine and the words in the ransom note,
    * return <strong>true</strong> if he can replicate his ransom note
    * exactly using whole words from the magazine; otherwise, return <strong>false</strong>.
    *
    * @param magazineText text from a magazine.
    * @param noteText text to compose.
    * @return true, if it's doable.
    */
  def isDoable(magazineText: String, noteText: String): Boolean = {
    val magazineWords = magazineText.split("\\s+").groupBy(identity).mapValues(_.length)
    val noteWords = noteText.split("\\s+").groupBy(identity).mapValues(_.length)

    noteWords.forall {
      case (word, count) => magazineWords.getOrElse(word, 0) >= count
    }
  }
}
