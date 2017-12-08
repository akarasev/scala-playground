package example

import org.scalatest.{FlatSpec, Matchers}

class PrimalitySpec extends FlatSpec with Matchers {

  "5" should "be prime" in {
    Primality.isPrime(5) shouldBe true
  }

  "7" should "be prime" in {
    Primality.isPrime(7) shouldBe true
  }

  "12" should "not be prime" in {
    Primality.isPrime(12) shouldBe false
  }

}
