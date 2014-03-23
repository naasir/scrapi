package org.naasir.scrapi.domain

/** A generic service for Queryable entities */
trait QueryableService[T <: Entity] {

  val repo: QueryableRepository[T]

  /** Gets all the entities that match the specified predicate.
    * 
    * @predicate the query predicate
    * @sort the sorting function
    * @limit the total number of entities to return
    * @offset the number of items to skip
    */
  def query(predicate: T => Boolean, sort: T => Any, limit: Int, offset: Int): List[T] = {
    repo.query(predicate, sort, limit, offset)
  }
}
