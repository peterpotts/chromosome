package com.peterpotts.chromosome

class FastaIterator(iterator: Iterator[String]) extends Iterator[(String, String)] {
  private val Header = "[>](.*)".r
  private val source = iterator.buffered
  private val builder = StringBuilder.newBuilder

  def hasNext: Boolean = source.hasNext

  def next(): (String, String) = {
    val Header(description) = source.next()
    builder.clear()
    while (source.hasNext && Header.unapplySeq(source.head).isEmpty) builder ++= source.next()
    description -> builder.toString
  }
}
