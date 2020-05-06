package com.tperrigo.hcl.screener

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import Screener.{characterCounts,repeatChars}

class CharacterMappingSpec extends AnyFlatSpec with Matchers {
  "characterCounts function" should "return an empty string when given an empty string" in {
    characterCounts("") shouldBe ""
  }

  it should "return the count of every character (where count > 0)" in {
    characterCounts("AAAAABCDDD") shouldBe "5ABC3D"
  }

  it should "skip over invalid characters" in {
    characterCounts("AAAAA$%#CDDD") shouldBe "5AC3D"
  }

  it should "be the inverse of repeatChars" in {
    val in = "10ABC27D"
    characterCounts(repeatChars(in)) shouldBe in
  }

  "repeatChars function" should "return an empty string when given an empty string" in {
    repeatChars("") shouldBe ""
  }

  it should "be the inverse of characterCounts" in {
    val in = "AAAAABCDDD"
    repeatChars(characterCounts(in)) shouldBe in
  }

  it should "skip over invalid characters" in {
    repeatChars("5A#$*3CZ") shouldBe "AAAAACCCZ"
  }
}