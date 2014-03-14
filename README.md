```
                               _ 
   ___________________ _____  (_)
  / ___/ ___/ ___/ __ `/ __ \/ / 
 (__  ) /__/ /  / /_/ / /_/ / /  
/____/\___/_/   \__,_/ .___/_/   
                    /_/          
```

A sample REST API implementation in Scala

## Quickstart

### Requirements

The following software components are required to be pre-installed in order to run this application:

* [scala](http://www.scala-lang.org/) `v2.10.3+`
* [sbt (scala build tool)](http://www.scala-sbt.org/) `v0.13.1`

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
    $ curl http://localhost:8080/api/user

> **NOTE**: Running the `sbt` command may result in a `OutOfMemoryError`. To fix this, you can increase the memory allocated to the JVM by following [these instructions](http://suhinini.me/2012/07/16/error-during-sbt-execution-java-lang-outofmemoryerror-permgen-space/) to create a `~/.sbtconfig` file.

## REST API

### USER resource

#### Get all users

Request

    `GET` http://localhost:8080/api/user

Response

```json
[
  {
    "email": "batman@test.com",
    "name": "Batman",
    "id": 1
  },
  {
    "email": "robin@test.com",
    "name": "Robin",
    "id": 2
  }
]
```
