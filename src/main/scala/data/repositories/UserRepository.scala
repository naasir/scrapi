package org.naasir.scrapi.data

import scala.slick.jdbc.JdbcBackend.{Database, Session}
import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.User

// user data store
class UserRepository(val db: Database) {

  val users = TableQuery[Users]

  // get the user with the specified id
  def get(id: Long): Option[User] = db.withSession { implicit session =>
    users.where(_.id === id).firstOption
  }

  def getAll(): List[User] = db.withSession { implicit session =>
    users.list
  }

  // gets the total number of users in the repo
  def count(): Long = db.withSession { implicit session =>
    users.length.run
  }

  // populate the repo with dummy data
  def populate = db.withSession { implicit session =>
    users ++= Seq(
      new User("batman@test.com", "Batman"),
      new User("robin@test.com", "Robin"),
      new User("alfred@test.com", "Alfred"),
      new User("joker@test.com", "Joker")
    )
  }
}
