package com.peterpotts.chromosome

import scala.collection.immutable.Seq

object SequentialZipper extends Zipper {
  def apply(fragments: Seq[Fragment]): String = {
    val map: Map[String, Fragment] = fragments.map(fragment => fragment.key -> fragment).toMap
    val Loop(initial, links) = fragments.foldLeft(Loop(map, Seq.empty))(loop)
    require(initial.size == 1)
    fold(initial.values.head, links)
  }

  private def loop(loop: Loop, left: Fragment): Loop = {
    val destinations: Map[String, Fragment] = loop.destinations - left.key

    val stream: Stream[Link] = destinations.values.toStream.flatMap { right =>
      Splicer(left.value, right.value).map(index => Link(left, right suffix index))
    }

    stream.headOption match {
      case Some(link) => Loop(loop.destinations - link.right.key, link +: loop.links)
      case None => loop
    }
  }

  private def fold(initial: Fragment, links: Seq[Link]): String = {
    val map: Map[String, SuffixFragment] = links.map(link => link.left.key -> link.right).toMap
    val builder = StringBuilder.newBuilder
    builder ++= initial.value
    var suffixFragment = map(initial.key)

    while (map contains suffixFragment.key) {
      builder ++= suffixFragment.suffix
      suffixFragment = map(suffixFragment.key)
    }

    builder ++= suffixFragment.suffix
    builder.toString
  }
}
