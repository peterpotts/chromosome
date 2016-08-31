import sbt._

object Settings {
  val name = "chromosome"
  val organization = "com.peterpotts"
  val version = "1.0.0-SNAPSHOT"
  val scalaVersion = "2.11.8"
  val scalaMajorVersion = scalaVersion.split('.').take(2).mkString(".")

  object Versions {
    val scalaModules = "1.0.4"
    val scalaTest = "2.2.6"
  }

  object Dependencies {
    val scalaCompiler = "org.scala-lang" % "scala-compiler" % scalaVersion
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest
  }

}
