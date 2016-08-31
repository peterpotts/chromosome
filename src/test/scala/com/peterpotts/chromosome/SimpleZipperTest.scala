package com.peterpotts.chromosome

import org.scalatest.{Matchers, WordSpec}

class SimpleZipperTest extends WordSpec with Matchers with ZipperBehavior {
  lazy val name = "simple"

  def fixture(test: Zipper => Any): Any = test(SimpleZipper)
}
