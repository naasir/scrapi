package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

/** slick base mapping for an entity table */
abstract class EntityTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[Option[Long]]("ID", O.PrimaryKey, O.AutoInc)
}
