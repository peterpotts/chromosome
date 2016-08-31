package com.peterpotts.chromosome

/**
  * The splicer function compares a left string and a right string. If they overlap in content by more than half the
  * length of both strings then the index position within the right string is returned.
  */
object Splicer extends ((String, String) => Option[Int]) {
  def apply(left: String, right: String): Option[Int] = {
    var index = math.max(left.length, right.length) / 2 + 1

    if (index > right.length) {
      None
    } else {
      while (index < right.length && mismatch(left, right, index)) index += 1
      if (index == right.length) None else Some(index)
    }
  }

  private def mismatch(left: String, right: String, index: Int): Boolean = {
    var leftIndex = left.length - 1
    var rightIndex = index - 1

    while (leftIndex >= 0 && rightIndex >= 0 && left.charAt(leftIndex) == right.charAt(rightIndex)) {
      leftIndex -= 1
      rightIndex -= 1
    }

    rightIndex >= 0
  }
}
