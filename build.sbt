
name := """play-akka-dbflute"""
organization := "com.example"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.18"
lazy val root = (project in file(".")).enablePlugins(PlayScala)
libraryDependencies ++=
  Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test,
    "com.mysql" % "mysql-connector-j" % "26.10.0",
    "org.playframework" %% "play-slick" % "6.2.0",
    "org.playframework" %% "play-slick-evolutions" % "6.2.0",
    "com.typesafe.slick" %% "slick-codegen" % "3.6.1")

// Keep Play's Jackson modules on the same patched 2.x line.
dependencyOverrides ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.21",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.21.8",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.21.8",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.21.8",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % "2.21.8",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.21.8",
  "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % "2.21.8",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.21.8",
  "com.google.guava" % "guava" % "33.8.0-jre")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
