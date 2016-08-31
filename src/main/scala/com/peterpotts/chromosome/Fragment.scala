package com.peterpotts.chromosome

import scala.collection.immutable.Seq

/**
  * Chromosome fragment.
  *
  * @param key   A description.
  * @param value A nucleotide sequence.
  */
case class Fragment(key: String, value: String) {
  def suffix(index: Int) = SuffixFragment(key, value, index)
}

/**
  * Suffix of a fragment.
  *
  * @param key   A description.
  * @param value A nucleotide sequence.
  * @param index The starting position of the nucleotide sub-sequence.
  */
case class SuffixFragment(key: String, value: String, index: Int) {
  lazy val suffix = value.substring(index)
}

/**
  * Link of two fragments.
  *
  * @param left  Left fragment.
  * @param right Right suffix fragment.
  */
case class Link(left: Fragment, right: SuffixFragment)

/**
  * Loop container for a left fold.
  *
  * @param from  Map of unlinked source fragments.
  * @param zero  Zero fragment.
  * @param links Links.
  */
case class Loop(zero: Option[Fragment], from: Map[String, Fragment], links: Seq[Link])