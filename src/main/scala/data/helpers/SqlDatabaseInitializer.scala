package org.naasir.scrapi.data

import javax.sql.DataSource
import com.mchange.v2.c3p0.ComboPooledDataSource
import scala.slick.jdbc.JdbcBackend.Database
import com.imageworks.migration.{
  DatabaseAdapter,
  Migrator,
  MigratorOperation,
  InstallAllMigrations,
  RemoveAllMigrations,
  Vendor
}

import org.naasir.scrapi.domain.DatabaseInitializer

/** A database manager responsible for initializing and destroying a SQL database */
object SqlDatabaseInitializer extends DatabaseInitializer {

  val datasource = createDatasource()
  val db = Database.forDataSource(datasource)

  /** Initializes the database */
  def initialize(): Database = {
    runMigrations(datasource, InstallAllMigrations)
    db
  }

  /** Destroys the database */
  def destroy() = {
    runMigrations(datasource, RemoveAllMigrations)
  }

  /**  Creates a DataSource instance from configuration */
  def createDatasource(): DataSource = {
    val datasource = new ComboPooledDataSource()
    datasource.setDriverClass("org.apache.derby.jdbc.EmbeddedDriver")
    datasource.setJdbcUrl("jdbc:derby:db;create=true")
    datasource.setUser("")
    datasource.setPassword("")
    datasource
  }

  /** Runs all of the database migrations
    * 
    * @param datasource to run the migrations on
    * @param operation the migration operation to perform (options: InstallAllMigrations, RemoveAllMigrations)
    */
  def runMigrations(datasource: DataSource, operation: MigratorOperation) = {
    val migrationAdapter = DatabaseAdapter.forVendor(Vendor.forDriver("org.apache.derby.jdbc.EmbeddedDriver"), None)
    val migrator = new Migrator(datasource, migrationAdapter)
    migrator.migrate(operation, "org.naasir.scrapi.data", false)
  }
}
