```
                               _ 
   ___________________ _____  (_)
  / ___/ ___/ ___/ __ `/ __ \/ / 
 (__  ) /__/ /  / /_/ / /_/ / /  
/____/\___/_/   \__,_/ .___/_/   
                    /_/          
```

A Scala flavored sample REST API with teeth.

## Quickstart

### Requirements

The following software components are required to be pre-installed in order to develop for this project:

* [scala](http://www.scala-lang.org/) `v2.10.3+`
* [sbt (simple build tool)](http://www.scala-sbt.org/) `v0.13.1`

### Installing Dependencies

Here is one method of installing all the necessary dependencies on a Mac via Homebrew:

    $ brew update
    $ brew install scala
    $ brew install sbt
    
    # test #
    $ scala -version
    $ sbt --version

### Running the server

Issue the following commands from a command shell to start the development web server:

    $ cd path/to/scrapi
    $ sbt run
    
    # test #
    $ curl http://localhost:8080/v1/user

> **NOTE**: Running the `sbt` command may result in a `OutOfMemoryError`. To fix this, you can increase the memory allocated to the JVM by following [these instructions](http://suhinini.me/2012/07/16/error-during-sbt-execution-java-lang-outofmemoryerror-permgen-space/) to create a `~/.sbtconfig` file.

## Development Notes

### Deploying the service

The deployment process produces a single java JAR file that can be executed from any machine that has the Java Runtime Environment `v1.6` or higher.

Issue the following commands from a command shell to build a deployment package and run it:

    $ sbt assembly
    $ java -jar target/scala-2.10/scrapi-assembly-0.1.0.jar

### Running the test suite

Issue the following commands from a command shell to run the test suite:

    $ sbt test

### Developing in Eclipse

Scala code can be developed in Eclipse via the [Scala IDE Plugin](http://scala-ide.org/download/current.html). You can visit their home page for the most up to date installation instructions, but it follows the same process for installing other Eclipse plugins:

1. Open Eclipse and from the top menu, select `Help > Install New Software...`
2. In the Install dialog, type in the address for the software site for the Scala IDE
  * For example: http://download.scala-ide.org/sdk/helium/e38/scala210/stable/site
3. Select the `Scala IDE for Eclipse` option and click Finish

Eclipse specific project files are not saved in this repository, but can be generated on demand with the following commands:

    $ cd path/to/scrapi
    $ sbt eclipse
    
Once this is done, open up Eclipse and perform the following steps:

1. Select your default workspace
2. From the top menu, select `File > Import...`
3. From the Import dialog, select `General > Existing projects into Workspace`
4. In the Import Projects dialog, ensure the `Select root directory` option is selected and browse to the location where the source files exist on your harddrive
5. Ensure the `Copy projects into workspace` option is NOT selected and then click Finish

## REST API

### USER resource

* `GET` /v1/user
  * Gets the first ten users
  * `GET` http://localhost:8080/v1/user
* `GET` /v1/user?page={number}&per_page={size}
  * Gets a range of users
  * `GET` http://localhost:8080/v1/user?page=1&per_page=2
* `GET` /v1/user/{id}
  * Gets the user with the specified id
  * `GET` http://localhost:8080/v1/user/1
* `PUT` /v1/user/{id}
  * Updates the user with the specified id
  * `PUT` http://localhost:8080/v1/user/1
* `DELETE` /v1/user/{id}
  * Deletes the user with the specified id
  * `DELETE` http://localhost:8080/v1/user/1
* `GET` /v1/user/{name}
  * Gets the user with the specified name (case-insensitive)
  * `GET` http://localhost:8080/v1/user/batman
* `DELETE` /v1/user/{name}
  * Deletes the user with the specified name (case-insensitive)
  * `DELETE` http://localhost:8080/v1/user/batman
  
## Technology Stack

* [Scala](http://www.scala-lang.org/) : The primary development language of this project.  
* [Spray](http://spray.io/) : Suite of Scala libraries built on top of [Akka](http://akka.io/) for building REST/HTTP services.
* [Slick](http://slick.typesafe.com/) : Modern database query and access library for Scala.
* [Scala Migrations](https://code.google.com/p/scala-migrations/) : Scala library for managing upgrades and rollbacks to database schemas.
* [ScalaTest](http://www.scalatest.org/) : Scala library for writing automated tests.
* [SBT](http://www.scala-sbt.org/) : Build tool for Scala and Java projects similar to Maven and Ant.
* [Derby](http://www.sqlite.org) : Java-based embedded SQL database engine for unit testing.
