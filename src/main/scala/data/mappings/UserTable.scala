package org.naasir.scrapi.data

import java.sql.Timestamp
import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.User

/** Slick-backed mapping for the user table */
class UserTable(tag: Tag) extends NameableTable[User](tag, "USER") {
  def email = column[String]("EMAIL")
  def active = column[Option[Boolean]]("ACTIVE")
  def createdAt = column[Option[Timestamp]]("CREATED_AT")
  def * = (email, name, active, createdAt, id) <> (User.tupled, User.unapply)
}
