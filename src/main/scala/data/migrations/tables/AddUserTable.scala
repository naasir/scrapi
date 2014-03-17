package org.naasir.scrapi.data

import com.imageworks.migration._

/** Database migration for adding the 'user' table */
class Migrate_20140228223141_AddUserTable extends Migration {
  val tableName = "user"

  def up() {
    createTable(tableName) { t =>
      t.bigint("id", PrimaryKey, AutoIncrement)
      t.varchar("name", NotNull, Limit(128))
      t.varchar("email", NotNull, Limit(256))
    }
  }

  def down() {
    dropTable(tableName)
  }
}
