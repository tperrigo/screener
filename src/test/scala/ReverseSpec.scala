package com.tperrigo.hcl.screener

import org.scalacheck.Properties
import org.scalacheck.Arbitrary
import org.scalacheck.Prop._

import Screener.reverse

object ReverseSpec extends Properties("reverse") {
  property("consistent with List.reverse") = forAll { (l: List[String]) =>
    reverse(l) == l.reverse
  }

  property("reversing a reversed list => orignal list") = forAll { (l: List[Int]) =>
    reverse(reverse(l)) == l
  }
}