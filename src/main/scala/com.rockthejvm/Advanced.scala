package com.rockthejvm
import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props

object ActorsIntro extends App {
  // part 1 - actor system
  val actorSystem = ActorSystem("firstactorsystem")
  println(actorSystem.name)

  // part 2 - create actors in actor system
  class WordCountActor extends Actor {
    var totalwords = 0
    def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        println(s"[word counter] I have received msg: $message")
        totalwords += message.split(" ").length
      case msg =>
        println(
          s"[word counter] could not understand msg of type ${msg.toString()}"
        )
    }
  }

  // part 3 - Instantiate Actor
  val wordCounter = actorSystem.actorOf(Props[WordCountActor](), "wordCounter")
  // part4 - communicate with the Actor
  wordCounter ! "I am learning Akka and it is pretty cool"

}
