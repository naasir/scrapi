package org.naasir.scrapi.service

import akka.actor.{Actor, Props}
import akka.event.Logging

import spray.routing._
import spray.http._
import spray.httpx.Json4sSupport

import MediaTypes._

import org.json4s.Formats
import org.json4s.DefaultFormats

import org.naasir.scrapi.data.UserRepository

class UserServiceActor(val repo: UserRepository) extends Actor with UserService {
  implicit def json4sFormats: Formats = DefaultFormats

  def actorRefFactory = context

  def receive = runRoute(route)
}

trait UserService extends HttpService with Json4sSupport {

  val repo: UserRepository

  val route =
    pathPrefix("v1") {
      path("user") {
        get {
          complete {
            repo.getAll()
          }
        }
      } ~
      path("user" / LongNumber) { id =>
        get {
          complete {
            repo.get(id)
          }
        }
      }
    }
}
