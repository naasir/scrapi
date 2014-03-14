package org.naasir.scrapi.domain

import scala.slick.jdbc.JdbcBackend.{Database}

/** A database manager responsible for initializing and destroying a database */
trait DatabaseInitializer {

  /** Initializes the database */
  def initialize(): Database

  /** Destroys the databse */
  def destroy()
}
