package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.{User, UserRepository}

/** Slick-backed repository of User entities */
class SlickUserRepository(val db: Database) extends SlickCrudRepository[UserTable, User] with UserRepository {

  val query = TableQuery[UserTable]

  // custom repository functions here...

}
