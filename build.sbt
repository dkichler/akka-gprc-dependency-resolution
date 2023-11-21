import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    name := "akka-grpc24-test",
    libraryDependencies += munit % Test,
    resolvers ++= Seq(
      "Akka library repository".at("https://repo.akka.io/maven"),
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
