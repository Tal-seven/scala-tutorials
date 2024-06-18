package com.rockthejvm

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Flow

object AkkaStreams extends App {

  val system = ActorSystem("AkkaStreams")
  implicit val materializer: ActorMaterializer = ActorMaterializer()(system)

  val source = Source(0 to 10)
  val sink = Sink.foreach[Int](println)

  val flow = Flow[Int].map(x => x * 2)

  val sourceWithFlow = source.via(flow)
  val flowToSink = flow.to(sink)
//   sourceWithFlow.to(sink).run()

  val namesSource = Source(
    List("jeff", "bob", "dennis", "luke", "ron", "john", "jerry")
  )
  val filteredFlow = Flow[String].filter(x => x.length() >= 5)
  val takeFilter = Flow[String].take(2)

  namesSource.via(filteredFlow).via(takeFilter).runForeach(println)
//   val graph = source.to(sink)
//   graph.run()(materializer)

}
