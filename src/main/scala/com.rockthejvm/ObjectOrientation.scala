package com.rockthejvm

object ObjectOrientation extends App{
  class Animal {
    val age: Int = 0
    def eat(): Unit = println("I am eating")
  }
  val anAnimal = new Animal

  class Dog(val name: String) extends Animal
  val aDog = new Dog("Lassie")

  val aDeclaredAnimal: Animal = Dog("Hutchie")
  aDeclaredAnimal.eat() 

  //abstract class 
  abstract class  WalkingAnimal {
    val hasLegs = true
    def walk(): Unit
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = println("I am eating : Animal")
  }

  val aCroc = new Crocodile
  aCroc eat aDog

  abstract class MyList[T] {
    def head(): T
    def tail(): MyList[T]
  }
}
