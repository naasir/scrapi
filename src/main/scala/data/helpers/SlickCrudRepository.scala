package org.naasir.scrapi.data

import scala.slick.driver.DerbyDriver.simple._
// import scala.slick.jdbc.JdbcBackend.{Database, Session}

import org.naasir.scrapi.domain.{Entity, CrudRepository}

/** A generic CRUD repository that leverages Slick 
  * 
  * @see http://crisdev.wordpress.com/2013/12/11/crud-trait-for-slick-2-0/
  */
trait SlickCrudRepository[T <: EntityTable[A], A <: Entity] extends CrudRepository[A] {

  val db: Database

  val query: TableQuery[T]

  def count(): Long = {
    db.withSession { implicit session =>
      query.length.run
    }
  }

  def get(id: Long): Option[A] = {
    db.withSession { implicit session =>
      query.where(_.id === id).firstOption
    }
  }

  def getAll(): List[A] = {
    db.withSession { implicit session =>
      query.list
    }
  }

  def save(entity: A) = {
    db.withSession { implicit session =>
      if (entity.id.isDefined) {
        query.where(_.id === entity.id).update(entity)
      }
      else {
        query += entity
      }
    }
  }

  def delete(id: Long) = {
    db.withSession { implicit session =>
      query.where(_.id === id).delete
    }
  }
}
