package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.User

/** slick  mapping for the user table */
class UserTable(tag: Tag) extends NameableTable[User](tag, "USER") {
  def email = column[String]("EMAIL")
  def * = (email, name, id) <> (User.tupled, User.unapply)
}
