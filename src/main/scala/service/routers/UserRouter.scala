package org.naasir.scrapi.service

import akka.actor.{Actor, Props}
import akka.event.Logging

import spray.routing._
import spray.http._
import spray.httpx.Json4sSupport

import MediaTypes._

import org.json4s.Formats
import org.json4s.DefaultFormats

import org.naasir.scrapi.domain.UserService

/** An Akka Actor for the UserRouter */
class UserRouterActor(val service: UserService) extends Actor with UserRouter {
  implicit def json4sFormats: Formats = DefaultFormats

  def actorRefFactory = context

  def receive = runRoute(route)
}

/** An HTTP request router for the User resource */
trait UserRouter extends HttpService with Json4sSupport {

  val service: UserService

  val route =
    pathPrefix("v1") {
      path("user") {
        get {
          complete {
            service.getAll()
          }
        }
      } ~
      path("user" / LongNumber) { id =>
        get {
          complete {
            service.get(id)
          }
        } ~
        delete {
          complete {
            service.delete(id)
            StatusCodes.NoContent
          }
        }
      } ~
      path("user" / Segment) { name =>
        get {
          complete {
            service.get(name)
          }
        } ~
        delete {
          complete {
            service.delete(name)
            StatusCodes.NoContent
          }
        }
      }
    }
}
