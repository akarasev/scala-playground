package example

import org.scalatest.{AsyncFlatSpec, Ignore, Matchers}

@Ignore
//These tests work, just enable the suite to see how it works
//The reason it was ignored - they significantly affect total execution time, e.g. $ sbt test.
class AsynchronousSampleSpec extends AsyncFlatSpec with Matchers {

  "sequential computations" should "take more than 6 seconds" in {
    val computer = new AsynchronousSample()

    val start = System.currentTimeMillis()
    computer.computeSumSequentially.map(result => {
      result shouldBe 6

      val timeElapsed = System.currentTimeMillis() - start
      assert(timeElapsed > 6000)
    })
  }

  "parallel computations (using 'val' keyword)" should "take less than 6 seconds" in {
    val computer = new AsynchronousSample()

    val start = System.currentTimeMillis()
    computer.computeSumParallelUsingCompanion.map(result => {
      result shouldBe 6

      val timeElapsed = System.currentTimeMillis() - start
      assert(timeElapsed < 6000)
    })
  }

  "parallel computations (using companion object)" should "take less than 6 seconds" in {
    val computer = new AsynchronousSample()

    val start = System.currentTimeMillis()
    computer.computeSumParallelUsingCompanion.map(result => {
      result shouldBe 6

      val timeElapsed = System.currentTimeMillis() - start
      assert(timeElapsed < 6000)
    })
  }

}
