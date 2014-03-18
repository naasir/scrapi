package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.{Nameable, NameableRepository}

/** A slick-backed generic repository for Nameable entities. */
trait SlickNameableRepository[T <: NameableTable[A], A <: Nameable] extends NameableRepository[A] {

  val db: Database

  val query: TableQuery[T]

  def get(name: String): Option[A] = {
    db.withSession { implicit session =>
      query.where(_.name.toLowerCase === name.toLowerCase).firstOption
    }
  }

  def delete(name: String) = {
    db.withSession { implicit session =>
      query.where(_.name.toLowerCase === name.toLowerCase).delete
    }
  }
}
