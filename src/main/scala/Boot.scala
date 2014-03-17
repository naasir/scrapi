package org.naasir.scrapi

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

import scala.slick.driver.{DerbyDriver}

import org.naasir.scrapi.data._
import org.naasir.scrapi.domain._
import org.naasir.scrapi.service._

/** The bootstrapper for the app */
object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem()

  val db = SqlDatabaseInitializer.initialize()
  val repo = new SlickUserRepository(db)
  val service = new UserService(repo)

  // create and start our service actor
  val handler = system.actorOf(Props(new UserRouterActor(service)), "user-service")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(handler, interface = "localhost", port = 8080)
}
