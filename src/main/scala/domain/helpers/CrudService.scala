package org.naasir.scrapi.domain

/** A generic CRUD (Create, Read, Update, Delete) service */
trait CrudService[T <: Entity] {

  val repo: CrudRepository[T]

  def get(id: Long): Option[T] = {
    repo.get(id)
  }

  def getAll(): List[T] = {
    repo.getAll()
  }

  def create(entity: T) = {
    repo.save(entity)
  }

  def update(entity: T) = {
    repo.save(entity)
  }

  def delete(id: Long) = {
    repo.delete(id)
  }
}
