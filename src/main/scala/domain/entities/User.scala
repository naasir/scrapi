package org.naasir.scrapi.domain

/** A user of the system.
  *
  * @constructor create a new user with email and name
  * @param email the users email
  * @param name the users display name
  */
case class User(
  email: String,
  name: String,
  id: Option[Long] = None
) extends Entity
