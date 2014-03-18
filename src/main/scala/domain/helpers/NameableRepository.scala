package org.naasir.scrapi.domain

/** A repository for Nameable entities */
trait NameableRepository[T <: Nameable] {

  /** Gets the entity with the specified name (case-insensitive)
    * 
    * @name the name of the entity
    */
  def get(name: String): Option[T]

  /** Deletes the entity with the specified name (case-insensitive)
    * 
    * @name the name of the entity
    */
  def delete(name: String)
}
