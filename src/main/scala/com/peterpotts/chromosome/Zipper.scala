package com.peterpotts.chromosome

import scala.collection.immutable.Seq

trait Zipper extends (Seq[Fragment] => String)
