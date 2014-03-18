package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.{User, UserRepository}

/** Slick-backed repository of User entities */
class SlickUserRepository(val db: Database)
    extends UserRepository
    with SlickCrudRepository[UserTable, User]
    with SlickNameableRepository[UserTable, User]
{
  val query = TableQuery[UserTable]

  // custom repository functions here...

}
