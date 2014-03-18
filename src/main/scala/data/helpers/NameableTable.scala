package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

/** Slick-backed table mapping for a nameable entity table */
abstract class NameableTable[T](tag: Tag, name: String) extends EntityTable[T](tag, name) {
  def name = column[String]("NAME")
}
