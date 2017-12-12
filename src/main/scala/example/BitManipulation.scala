package example

/**
  * <h3>Bit manipulation: Lonely integer</h3>
  * <p>
  *   Consider an array of n integers,
  *   A = [a<sub>0</sub>, a<sub>1</sub>, ... , a<sub>n-1</sub>],
  *   where all but one of the integers occur in pairs.
  *   In other words, every element in A occurs exactly twice
  *   except for one unique element.
  * </p>
  * <p>
  *   Given A, find and return the unique element.
  * </p>
  */
object BitManipulation {

  /**
    * Find unique element.
    *
    * @param list of integers.
    * @return unique value.
    */
  def findUnique(list: List[Int]): Int = list.reduceLeft((b, a) => a ^ b)
}
