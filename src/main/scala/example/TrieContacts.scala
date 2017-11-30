package example

/**
  * <h3>Tries: Contacts</h3>
  * <p>
  *   Contact application based on Trie data structure.
  *   The app adds contact name and counts contacts by given partial word (prefix).
  * </p>
  * <h3>Constraints</h3>
  * <ul>
  *   <li>It is guaranteed that 'name' and 'partial' contain lowercase English letters only.</li>
  *   <li>The input doesn't have any duplicate name for the add operation.</li>
  * </ul>
  */
object TrieContacts {

  /**
    * Add name to the contacts app.
    *
    * @param name a string denoting a contact name
    */
  def add(name: String): Unit = {
    ???
  }

  /**
    * Count the number of contacts starting with partial.
    *
    * @param partial a string denoting a partial name to search the application for.
    * @return contact count.
    */
  def find(partial: String): Int = {
    ???
  }

}
