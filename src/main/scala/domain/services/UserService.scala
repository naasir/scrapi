package org.naasir.scrapi.domain

/** A service for managing User entities */
class UserService(val repo: UserRepository) extends CrudService[User] {

  // custom user service methods here...

}
