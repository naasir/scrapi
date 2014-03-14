package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.User

// slick  mapping for the user table
class Users(tag: Tag) extends Table[User](tag, "USER") {
  def id = column[Option[Long]]("ID", O.PrimaryKey, O.AutoInc)
  def email = column[String]("EMAIL")
  def name = column[String]("NAME")
  def * = (email, name, id) <> (User.tupled, User.unapply)
}
