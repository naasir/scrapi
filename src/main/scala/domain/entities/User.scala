package org.naasir.scrapi.domain

import java.sql.Timestamp

/** A user of the system.
  *
  * @constructor create a new user with email and name
  * @param email the users email
  * @param name the users display name
  */
case class User(
  email: String,
  name: String,
  active: Option[Boolean] = Some(true),
  createdAt: Option[Timestamp] = Some(new Timestamp(System.currentTimeMillis())),
  id: Option[Long] = None
) extends Entity with Nameable
