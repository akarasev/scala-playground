package example

/**
  * <h3>Strings: making anagrams</h3>
  * <p>
  *   Alice is taking a cryptography class and finding anagrams to be very useful.
  *   We consider two strings to be anagrams of each other if the first string's
  *   letters can be rearranged to form the second string.
  *   In other words, both strings must contain the same exact letters
  *   in the same exact frequency For example, bacdc and dcbac are anagrams,
  *   but bacdc and dcbad are not.
  * </p>
  * <p>
  *   Alice decides on an encryption scheme involving two large strings
  *   where encryptionis dependent on the minimum number of character deletions
  *   required to make the two strings anagrams.
  * </p>
  *
  * <h3></h3>
  * <ul>
  *   <li>1 &le; |a|,|b| &le; 10<sup>4</sup></li>
  *   <li>It is guaranteed that a and b consist of lowercase English alphabetic letters (i.e., a through z).</li>
  * </ul>
  */
object Anagram extends App {

  /**
    * Given two strings, a and b, that may or may not be of the same length,
    * determine the minimum number of character deletions required to make a and b anagrams.
    *
    * @param first first string.
    * @param second second string.
    * @return minimum number of character deletions.
    */
  def calcDeletions(first: String, second: String): Int = {
    var result = 0

    val alphabetSize = 26

    val firstFrequencies = new Array[Int](alphabetSize)
    val secondFrequencies = new Array[Int](alphabetSize)

    first.foreach(character => firstFrequencies(character - 'a') += 1)
    second.foreach(character => secondFrequencies(character - 'a') += 1)

    for (index <- 0 until alphabetSize) {
      if (firstFrequencies(index) > secondFrequencies(index)) {
        result += firstFrequencies(index) - secondFrequencies(index)
      }

      if (secondFrequencies(index) > firstFrequencies(index)) {
        result += secondFrequencies(index) - firstFrequencies(index)
      }
    }

    result
  }

}
