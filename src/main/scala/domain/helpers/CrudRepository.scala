package org.naasir.scrapi.domain

/** A generic CRUD (Create, Read, Update, Delete) repository trait */
trait CrudRepository[T <: Entity] {

  /** Gets the total count of all the entities in this repository. */
  def count(): Long

  /** Gets the entity with the specified id.
    * 
    * @id the id of the entity
    */
  def get(id: Long): Option[T]

  /** Gets all of the entities in this repository. */
  def getAll(): List[T]

  /** Saves the specified entity.
    * 
    * @entity the entity to save
    */
  def save(entity: T)

  /** Deletes the entity with the specified id.
    * 
    * @id the id of the entity
    */
  def delete(id: Long)
}
