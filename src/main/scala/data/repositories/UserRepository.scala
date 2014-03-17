package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.User

/** Repository of User entities */
class UserRepository(val db: Database) extends SlickCrudRepository[UserTable, User] {

  val query = TableQuery[UserTable]

  // custom repository functions here...

}
