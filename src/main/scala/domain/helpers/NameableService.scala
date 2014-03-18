package org.naasir.scrapi.domain

/** A generic service for Nameable entities */
trait NameableService[T <: Nameable] {

  val repo: NameableRepository[T]

  def get(name: String): Option[T] = {
    repo.get(name)
  }

  def delete(name: String) = {
    repo.delete(name)
  }
}
