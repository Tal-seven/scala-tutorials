package  com.rockthejvm 

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

object ActorCapabilities extends App {
  class SimpleActor extends Actor {
    override def receive: Receive = {
      case "Hi" => context.sender() ! "Hello there"
      case message: String => println(s"[$self] i have received $message")
      case sayHiTo(ref) => ref ! "Hi"
    }
  }

  val system = ActorSystem("ActorCapabilitiesDemo")

  val simpleActor = system.actorOf(Props[SimpleActor](),"simpleActor")

  simpleActor ! "hello actor"
  
  val alice = system.actorOf(Props[SimpleActor](),"alice")
  val bob = system.actorOf(Props[SimpleActor](),"bob")

  case class sayHiTo(ref: ActorRef)

  alice ! sayHiTo(bob)
}
