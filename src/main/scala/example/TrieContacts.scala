package example

import scala.collection.mutable

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

  class Node {
    private val children = mutable.Map[Char, Node]()
    private var size = 0

    def add(text: String): Unit = {
      size += 1

      if (!text.isEmpty) {
        val node = children.getOrElseUpdate(text.head, new Node())
        node.add(text.tail)
      }
    }

    def find(criteria: String): Int = {
      if (criteria.isEmpty) {
        size
      } else if (!children.contains(criteria.head)) {
        0
      } else {
        children(criteria.head).find(criteria.tail)
      }
    }
  }

  val root = new Node()

  /**
    * Add name to the contacts app.
    *
    * @param name a string denoting a contact name
    */
  def add(name: String): Unit = {
    root.add(name)
  }

  /**
    * Count the number of contacts starting with partial.
    *
    * @param partial a string denoting a partial name to search the application for.
    * @return contact count.
    */
  def find(partial: String): Int = {
    root.find(partial)
  }

}
