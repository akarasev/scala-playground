package example

/**
  * <h3>Time complexity: Primality</h>
  * <p>
  *   A prime is a natural number greater than 1 that has no positive divisors
  *   other than 1 and itself. Given an integer, determine the primality
  *   of the integer and return whether it is Prime (true) or Not prime (false).
  * </p>
  *
  * <h3>Constraints</h3>
  * <ul>
  *   <li>1 &le; p &le; 30</li>
  *   <li>1 &le; n &le; 2 x 10<sup>9</sup></li>
  *   <li>implementation should be better then O(n)</li>
  * </ul>
  */
object Primality {
  val primes = Stream.cons(2, Stream from(3, 2) filter isPrime)

  def isPrime(n: Int): Boolean = {
    (n > 1) && (primes takeWhile { _ <= math.sqrt(n) } forall { n % _ != 0 })
  }

}
