package com.peterpotts.chromosome

import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

trait ZipperBehavior {
  self: WordSpec with Matchers =>
  val name: String

  def fixture(test: Zipper => Any): Any

  s"A $name zipper" should {
    "zip a small example" in fixture { target =>
      val lines = Source.fromURL(getClass.getResource("/small.fas")).getLines()
      val fragments = new FastaIterator(lines).map(Fragment.tupled).toIndexedSeq
      target(fragments) shouldEqual "ATTAGACCTGCCGGAATAC"
    }
  }
}