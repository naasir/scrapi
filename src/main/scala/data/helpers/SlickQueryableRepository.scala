package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._

import org.naasir.scrapi.domain.{Entity, QueryableRepository}

/** A slick-backed generic repository for queryable entities. */
trait SlickQueryableRepository[T <: EntityTable[A], A <: Entity] extends QueryableRepository[A] {

  val db: Database

  val query: TableQuery[T]

  def count(predicate: A => Boolean): Long = {
    db.withSession { implicit session =>
      // @todo fix this
      query.length.run
    }
  }

  def first(predicate: A => Boolean): Option[A] = {
    db.withSession { implicit session =>
      // @todo fix this
      query.firstOption
    }
  }

  def query(predicate: A => Boolean, sort: A => Any, limit: Int, offset: Int): List[A] = {
    db.withSession { implicit session =>
      // @todo fix this
      query.drop(offset).take(limit).list
    }
  }
}
