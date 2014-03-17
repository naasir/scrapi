package org.naasir.scrapi.data

import javax.sql.{DataSource}

import org.apache.derby.jdbc.{EmbeddedDataSource}

import scala.slick.jdbc.JdbcBackend.{Database}

import com.imageworks.migration.{DatabaseAdapter,
  Migrator,
  MigratorOperation,
  InstallAllMigrations,
  RemoveAllMigrations,
  Vendor}

import org.naasir.scrapi.domain.DatabaseInitializer

/** A database manager responsible for initializing and destroying a SQL database */
object SqlDatabaseInitializer extends DatabaseInitializer {

  /** Initializes the database */
  def initialize(): Database = {
    val datasource = createDatasource()
    runMigrations(datasource, InstallAllMigrations)
    Database.forDataSource(datasource)
  }

  /** Destroys the database */
  def destroy() = {
    val datasource = createDatasource()
    runMigrations(datasource, RemoveAllMigrations)
  }

  /**  Creates a DataSource instance from configuration */
  def createDatasource(): DataSource = {
    val datasource = new EmbeddedDataSource()
    datasource.setUser("")
    datasource.setPassword("")
    datasource.setDatabaseName("db")
    datasource.setCreateDatabase("create")
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
