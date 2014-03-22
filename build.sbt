// imports
import AssemblyKeys._

// project info
name := "scrapi"

version := "0.1.0"

// scala compiler configuration
scalaVersion := "2.10.3"

// see: http://www.scala-lang.org/old/sites/default/files/linuxsoft_archives/docu/files/tools/scalac.html
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

// library repositories
resolvers ++= Seq(
  "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io/"
)

// dependencies
val akkaVersion = "2.3.0"
val sprayVersion = "1.3.1"

libraryDependencies ++= Seq (
  // -- Testing --
  "org.scalatest"  % "scalatest_2.10"              % "2.1.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test",
  // -- Akka --
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j"   % akkaVersion,
  // -- Spray --
  "io.spray" % "spray-routing" % sprayVersion,
  "io.spray" % "spray-can"     % sprayVersion,
  "io.spray" % "spray-httpx"   % sprayVersion,
  "io.spray" % "spray-testkit" % sprayVersion % "test",
  // -- Utility --
  "ch.qos.logback" %  "logback-classic" % "1.1.1",
  "org.json4s"     %% "json4s-native"   % "3.2.6",
  // -- Database --
  "com.imageworks.scala-migrations" %% "scala-migrations" % "1.1.1",
  "org.apache.derby"                %  "derby"            % "10.10.1.1",
  "com.typesafe.slick"              %% "slick"            % "2.0.0",
  "com.mchange"                     %  "c3p0"             % "0.9.5-pre6"
)

// sbt-assembly plugin settings
assemblySettings
