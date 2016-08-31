package com.peterpotts.chromosome

import org.scalatest.{Matchers, WordSpec}

class SplicerTest extends WordSpec with Matchers {
  "A splicer" should {
    "handle over half of odd" in {
      Splicer("123", "234") shouldEqual Some(2)
    }

    "handle over half of even" in {
      Splicer("1234", "2345") shouldEqual Some(3)
    }

    "handle under half of odd" in {
      Splicer("123", "345") shouldEqual None
    }

    "handle exactly half of even" in {
      Splicer("1234", "3456") shouldEqual None
    }

    "handle over half odd even" in {
      Splicer("12345", "3456") shouldEqual Some(3)
    }

    "handle over half even odd" in {
      Splicer("1234", "2345") shouldEqual Some(3)
    }

    "handle over half superset" in {
      Splicer("1234567890", "345678") shouldEqual None
    }

    "handle over half subset" in {
      Splicer("345678", "1234567890") shouldEqual None
    }

    "handle over half right suffix" in {
      Splicer("1234567890", "34567890") shouldEqual None
    }

    "handle over half left suffix" in {
      Splicer("34567890", "1234567890") shouldEqual None
    }

    "handle over half right prefix" in {
      Splicer("1234567890", "12345678") shouldEqual None
    }

    "handle over half left prefix" in {
      Splicer("12345678", "1234567890") shouldEqual Some(8)
    }

    "handle left much bigger than right" in {
      Splicer("123456789", "890") shouldEqual None
    }

    "handle right much bigger than left" in {
      Splicer("123", "234567890") shouldEqual None
    }
  }
}
