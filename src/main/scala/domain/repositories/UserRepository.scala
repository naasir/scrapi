package org.naasir.scrapi.domain

/** A user repository trait */
trait UserRepository extends CrudRepository[User] with NameableRepository[User] {

  // custom user repository methods here...

}
