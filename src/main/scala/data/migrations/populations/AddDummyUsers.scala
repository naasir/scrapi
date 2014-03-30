package org.naasir.scrapi.data

import com.imageworks.migration._
import org.naasir.scrapi.domain.User

/** Database migration for adding dummy user records */
class Migrate_20140325214512_AddDummyUsers extends Migration {
  val db = SqlDatabaseInitializer.db

  val repo = new SlickUserRepository(db)

  val data = Seq(
    new User("batman@test.com", "Batman"),
    new User("robin@test.com", "Robin"),
    new User("alfred@test.com", "Alfred"),
    new User("joker@test.com", "Joker", Some(false)),
    new User("two.face@test.com", "Two-Face")
  )

  def up() {
    data.foreach((user: User) => repo.save(user))
  }

  def down() {
    // do nothing
  }
}
