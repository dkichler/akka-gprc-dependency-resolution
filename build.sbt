import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val one = (project in file(".mod-one"))
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    name := "akka-grpc24-test1",
    libraryDependencies += munit % Test,
    resolvers ++= Seq(
      "Akka library repository".at("https://repo.akka.io/maven"),
    )
  )

lazy val two = (project in file(".mod-two"))
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    name := "akka-grpc24-test2",
    libraryDependencies += munit % Test,
    resolvers ++= Seq(
      "Akka library repository".at("https://repo.akka.io/maven"),
    )
  )
  .dependsOn(one)


lazy val root = project.in(file("."))
  .settings(
    publish / skip := true,
    publishLocal / skip := true
  )
  .aggregate(one, two)
