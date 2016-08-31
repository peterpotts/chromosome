package com.peterpotts.chromosome

import scala.collection.immutable.Seq

object SimpleZipper extends Zipper {
  def apply(fragments: Seq[Fragment]): String = {
    def loop(loop: Loop, y: Fragment): Loop = {
      val xxx = (loop.from - y.key).values.flatMap { (x: Fragment) =>
        link(x.value, y.value).map(index => Link(x, y.suffix(index)))
      }

      xxx.headOption match {
        case Some(link) =>
          loop.copy(from = loop.from - link.left.key, links = loop.links :+ link)
        case None =>
          require(loop.zero.isEmpty)
          loop.copy(zero = Some(y))
      }
    }

    val map = fragments.map(fragment => fragment.key -> fragment).toMap
    val Loop(Some(zero), empty, links) = fragments.foldLeft(Loop(None, map, Seq.empty))(loop)
    println(zero)
    println(empty)
    links.foreach(println)
    require(empty.isEmpty)
    fold(zero, links)
  }

  private def fold(zero: Fragment, links: Seq[Link]): String = {
    val map = links.map(link => link.left.key -> link.right).toMap
    def zip(x: String, y: SuffixFragment): String = x ++ y.suffix
    var x = zero.value
    var y = map(zero.key)

    while (map contains y.key) {
      val z = map(y.key)
      x = zip(x, y)
      y = z
    }

    zip(x, y)
  }

  private def link(x: String, y: String): Option[Int] = {
    var i = y.length / 2 + 1
    while (i < y.length && mismatch(x, y, i)) i += 1
    if (i == y.length) None else Some(i)
  }

  private def mismatch(x: String, y: String, i: Int): Boolean = {
    var j = x.length - 1
    var k = i - 1

    while (j >= 0 && k >= 0 && x.charAt(j) == y.charAt(k)) {
      j -= 1
      k -= 1
    }

    j >= 0 && k >= 0
  }
}
