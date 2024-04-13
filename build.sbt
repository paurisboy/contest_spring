ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"
scalacOptions ++= Seq("-encoding", "utf-8")
lazy val root = (project in file("."))
  .settings(
    name := "contest_spring",
    libraryDependencies += "com.danielasfregola" %% "random-data-generator" % "2.8"
  ).enablePlugins(JmhPlugin)
