package com.peterpotts.chromosome

import scala.io.Source

object Application {
  def main(args: Array[String]): Unit = {
    val lines = Source.fromURL(getClass.getResource("/large.fas")).getLines()
    val fragments = new FastaIterator(lines).map(Fragment.tupled).toIndexedSeq
    println(SequentialZipper(fragments))
  }
}
