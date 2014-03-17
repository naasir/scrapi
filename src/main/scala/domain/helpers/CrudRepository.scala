package org.naasir.scrapi.domain

/** A generic CRUD (Create, Read, Update, Delete) repository trait */
trait CrudRepository[T <: Entity] {

  def count(): Long

  def get(id: Long): Option[T]

  def getAll(): List[T]

  def save(entity: T)

  def delete(id: Long)
}
