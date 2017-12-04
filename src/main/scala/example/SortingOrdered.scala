package example

/**
  * <h3>Sorting: Ordered</h3>
  * <p>
  *   Given an array of n Player objects,
  *   write a comparator that sorts them in order of decreasing score;
  *   if 2 or more players have the same score,
  *   sort those players alphabetically by name.
  * </p>
  * <h3>Constraints</h3>
  * <ul>
  *   <li>0 &le; score &le; 1000</li>
  *   <li>Two or more players can have the same name.</li>
  *   <li>Player names consist of lowercase English alphabetic letters.</li>
  * </ul>
  */
object SortingOrdered {

  case class Player(name: String, score: Int) extends Ordered[Player] {
    override def compare(that: Player): Int = {
      if (this.score != that.score) {
        -1 * this.score.compareTo(that.score)
      } else {
        this.name.compareTo(that.name)
      }
    }
  }

  def sort(players: Array[Player]): Array[Player] = {
    players.sorted
  }

}
