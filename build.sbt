import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "1.0.0"
ThisBuild / organization     := "com.tperrigo"

lazy val root = (project in file("."))
  .settings(
    name := "screener",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += scalaCheck % Test
  )
