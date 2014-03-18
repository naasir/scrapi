package org.naasir.scrapi.domain

/** An object with an id. */
trait Entity {
  val id: Option[Long]
}
