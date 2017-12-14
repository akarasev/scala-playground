package example

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * <h3>Asynchronous sample: Future</h3>
  * <p>
  *   The sample shows using Scala approach to async programming - <code>scala.concurrent.Future</code>.
  *   A set of featured could be executed sequentially or in parallel.
  * </p>
  */
class AsynchronousSample {

  def getOne: Future[Int] = Future {
    Thread.sleep(1000)
    1
  }

  def getTwo: Future[Int] = Future {
    Thread.sleep(2000)
    2
  }

  def getThree: Future[Int] = Future {
    Thread.sleep(3000)
    3
  }

  /**
    * Compute the sum of three <code>Future</code>'s sequentially.
    *
    * @return future 6
    */
  def computeSumSequentially: Future[Int] = {
    for {
      one   <- getOne
      two   <- getTwo
      three <- getThree
    } yield {
      one + two + three
    }
  }

  /**
    * Compute the sum of three <code>Future</code>'s in parallel using <code>val</code>.
    *
    * @return future 6
    */
  def computeSumParallelUsingVal:Future[Int] = {
    val futureOne = getOne
    val futureTwo = getTwo
    val futureThree = getThree

    for {
      one   <- futureOne
      two   <- futureTwo
      three <- futureThree
    } yield {
      one + two + three
    }
  }

  /**
    * Compute the sum of three <code>Future</code>'s in parallel
    * using Future companion object's <code>sequence</code> function.
    *
    * @return future 6
    */
  def computeSumParallelUsingCompanion:Future[Int] = {
    Future.sequence(Seq(getOne, getTwo, getThree)).map(_.sum)
  }

}
