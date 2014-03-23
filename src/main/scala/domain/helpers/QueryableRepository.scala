package org.naasir.scrapi.domain

/** A generic queryable repository trait */
trait QueryableRepository[T <: Entity] {

  /** Gets the count of all the entities in this repository that match the specified predicate.
    * 
    * @predicate the query predicate  
    */
  def count(predicate: T => Boolean): Long

  /** Gets the the first entity that matches the specified predicate.
    * 
    * @predicate the query predicate
    */
  def first(predicate: T => Boolean): Option[T]
  
  /** Gets all the entities that match the specified predicate.
    * 
    * @predicate the query predicate
    * @sort the sorting function
    * @limit the total number of entities to return
    * @offset the number of items to skip
    */
  def query(predicate: T => Boolean, sort: T => Any, limit: Int, offset: Int): List[T]
}
