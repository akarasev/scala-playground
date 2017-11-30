package example

import scala.collection.mutable

/**
  * <h3>Heaps: Find the Running Median</h3>
  * <p>
  *   The median of a dataset of integers is the midpoint value of the dataset
  *   for which an equal number of integers are less than and greater than the value.
  *   To find the median, it's needed first sort the dataset of integers in
  *   non-decreasing order, then:
  * </p>
  * <ol>
  *   <li>
  *     If the dataset contains an odd number of elements, the median is
  *     the middle element of the sorted sample.
  *     In the sorted dataset {1, 2, 3}, 2 is the median.
  *   </li>
  *   <li>
  *     If the dataset contains an even number of elements,
  *     the median is the average of the two middle elements of the sorted sample.
  *     In the sorted dataset {1, 2, 3, 4}, (2 + 3)/2 = 2.5 is the median.
  *   </li>
  * </ol>
  * <p>
  *   Given list of integers, perform the following task:
  * </p>
  * <ol>
  *   <li>Add the i<sup>th</sup> to a running list of integers.</li>
  *   <li>Find the median of the updated list</li>
  *   <li>
  *     Return all medians as a list.
  *     The medians must be double-precision numbers scaled to decimal place.
  *   </li>
  * </ol>
  */
object HeapsRunningMedian {

  private val minHeap = mutable.PriorityQueue.empty[Int]

  private val maxHeap = mutable.PriorityQueue.empty[Int].reverse

  /**
    * Simulate adding integers one by one and return all medians of the list.
    *
    * @param items list of integers.
    * @return all medians.
    */
  def getMedians(items: List[Int]): List[Double] = {

    def process(value: Int): Double = {

      if (minHeap.isEmpty || value < minHeap.clone.dequeue) {
        minHeap.enqueue(value)
      } else {
        maxHeap.enqueue(value)
      }

      if (math.abs(minHeap.size - maxHeap.size) > 1) {
        if (minHeap.size > maxHeap.size) {
          maxHeap.enqueue(minHeap.dequeue)
        } else {
          minHeap.enqueue(maxHeap.dequeue)
        }
      }

      val median =
        if (minHeap.size > maxHeap.size) {
          minHeap.clone.dequeue
        } else if (minHeap.size < maxHeap.size) {
          maxHeap.clone.dequeue
        } else {
          (minHeap.clone.dequeue.toDouble + maxHeap.clone.dequeue) / 2
        }

      median
    }

    items map process
  }
}
