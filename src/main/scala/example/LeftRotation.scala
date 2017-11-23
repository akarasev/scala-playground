package example

/**
  * <h3>Arrays</h3>
  * <p>
  *   A left rotation operation on an array of size n shifts each
  *   of the array's elements 1 unit to the left.
  *   For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5],
  *   then the array would become [3, 4, 5, 1, 2].
  * </p>
  * <p>
  *   Given an array of n integers and a number, d, performs d left rotations on the array.
  * </p>
  *
  * <h3>Constraints</h3>
  * <ul>
  *   <li>1 &le; n &le; 10<sup>5</sup></li>
  *   <li>1 &le; d &le; n</li>
  *   <li>1 &le; a<sub>i</sub> &le; 10<sup>6</sup></li>
  * </ul>
  *
  */
object LeftRotation extends App {

  def rotate(items: Array[Int], position: Int): Array[Int] = {
    require(position >= 1 && position <= items.length)

    items.drop(position) ++ items.take(position)
  }
}
