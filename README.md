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
    $ curl http://localhost:8080/v1/user

> **NOTE**: Running the `sbt` command may result in a `OutOfMemoryError`. To fix this, you can increase the memory allocated to the JVM by following [these instructions](http://suhinini.me/2012/07/16/error-during-sbt-execution-java-lang-outofmemoryerror-permgen-space/) to create a `~/.sbtconfig` file.

## Development Notes

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

#### Get user by ID

Request

`GET` http://localhost:8080/v1/user/{id}

Response

```json
{
  "email": "batman@test.com",
  "name": "Batman",
  "id": 1
}
```

#### Get all users

Request

`GET` http://localhost:8080/v1/user

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
  },
  ...
]
```
