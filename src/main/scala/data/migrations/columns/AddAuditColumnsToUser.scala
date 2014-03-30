package org.naasir.scrapi.data

import com.imageworks.migration._

/** Database migration for adding the 'user' table */
class Migrate_20140324202810_AddAuditColumnsToUser extends Migration {
  val tableName = "user"

  def up() {
    addColumn(tableName, "active", SmallintType, NotNull, Default(0))
    addColumn(tableName, "created_at", TimestampType)
  }

  def down() {
    removeColumn(tableName, "active")
    removeColumn(tableName, "created_at")
  }
}
