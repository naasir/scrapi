package org.naasir.scrapi

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import org.apache.derby.jdbc._
import com.imageworks.migration._
import scala.slick.jdbc.JdbcBackend.{Database, Session}

import org.naasir.scrapi.data._
import org.naasir.scrapi.service._

object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem()

  // create the database
  val migrationAdapter = DatabaseAdapter.forVendor(Vendor.forDriver("org.apache.derby.jdbc.EmbeddedDriver"), None)
  val dataSource = new EmbeddedDataSource()
  dataSource.setUser("")
  dataSource.setPassword("")
  dataSource.setDatabaseName("db")
  dataSource.setCreateDatabase("create")
  val migrator = new Migrator(dataSource, migrationAdapter)
  migrator.migrate(InstallAllMigrations, "org.naasir.scrapi.data", false)

  val db = Database.forDataSource(dataSource)
  val repo = new UserRepository(db)
  repo.populate

  // create and start our service actor
  val handler = system.actorOf(Props(new UserServiceActor(repo)), "user-service")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(handler, interface = "localhost", port = 8080)
}
