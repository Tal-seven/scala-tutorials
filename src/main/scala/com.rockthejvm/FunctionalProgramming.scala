package com.rockthejvm

object FunctionalProgramming extends App{
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  val ret = simpleIncrementer(785)
  println(s"applying simple increment: $ret")

  val doubler: Function1[Int, Int] = (x: Int) => 2 * x

  val tripler: Int => Int = (x: Int) => 3 * x

  // higher order functions
  val flatMappedList = List(1,2,3).flatMap(x => List(x, x * 2))

  println(s"flat mapped list $flatMappedList")

  val filteredList = List(1,2,3,4,5).filter(x => x % 2 == 0)

  println(filteredList)

  val allPairs = List(1,2,3).flatMap(x => List('a','b','c').flatMap(letter => List(s"$x-$letter")))

  //for comprehensions

  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"
  println(allPairs)  
  println(alternativePairs)
}
