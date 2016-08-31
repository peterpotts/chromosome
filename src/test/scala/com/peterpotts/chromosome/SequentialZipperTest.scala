package com.peterpotts.chromosome

import org.scalatest.{Matchers, WordSpec}

class SequentialZipperTest extends WordSpec with Matchers with ZipperBehavior {
  lazy val name = "sequential"

  def fixture(test: Zipper => Any): Any = test(SequentialZipper)
}
