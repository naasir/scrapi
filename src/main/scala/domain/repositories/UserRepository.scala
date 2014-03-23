package org.naasir.scrapi.domain

/** A user repository trait */
trait UserRepository extends CrudRepository[User] with NameableRepository[User] with QueryableRepository[User] {

  // custom user repository methods here...

}
