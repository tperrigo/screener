package com.tperrigo.hcl.screener

import scala.annotation.tailrec

object Screener extends App {

  def reverse[A](list: List[A]): List[A] = {
    @tailrec
    def recurse(result: List[A], l: List[A]): List[A] = l match {
      case Nil => result
      case head :: tail => recurse(head :: result, tail)
    }
    recurse(Nil, list)
  }

  def characterCounts(s: String): String = {
    s.foldRight(List.empty[(Int, Char)]) {
      case (char, (count, c)::tail) if char == c => (count + 1, char) :: tail
      case (char, list) if char.isLetter => (1, char) :: list
      case (_, list) => list
    }.map { tuple => 
      if (tuple._1 > 1) s"${tuple._1}${tuple._2}" 
      else s"${tuple._2}"
    }.mkString
  }

  def repeatChars(s: String): String = {
    val regex = raw"(\d*+\p{Alpha}{1})".r
    regex.findAllIn(s).map(_.span(_.isDigit)).map { tuple => tuple match {
      case ("", ch) => ch
      case (count, ch) => ch * count.toInt
    }}.mkString
  }
  
  println("Screener application submission by Timothy Perrigo")
  println(s"reverse(List(1,2,3) ==> ${reverse(List(1,2,3))}")
  val s1 = "ABBBBBZZ"
  val s2 = "A5B2Z"
  println(s"characterCounts($s1) ==> ${characterCounts(s1)}")
  println(s"repeatChars($s2) ==> ${repeatChars(s2)}")
}