package example

import scala.annotation.tailrec

/**
  * <h3>Merge sort</h3>
  */
object MergeSort {

  /**
    * Perform sort of a list.
    *
    * @param list values.
    * @return sorted list.
    */
  def sort(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case head :: Nil => List(head)
      case _ =>
        list.splitAt(list.length / 2) match {
          case (Nil, _) => list
          case (_, Nil) => list
          case (xs, xy) =>
            merge(sort(xs), sort(xy))
        }
    }
  }

  @tailrec
  private def merge(xs: List[Int], ys: List[Int], acc: List[Int] = Nil): List[Int] = {
    (xs, ys) match {
      case (Nil, _) => acc ++ ys
      case (_, Nil) => acc ++ xs
      case (headX :: tailX, headY :: tailY) =>
        if (headX < headY) merge(tailX, ys, acc :+ headX)
        else merge(xs, tailY, acc :+ headY)
    }
  }

}
