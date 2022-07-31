name := "TestingInScala"

version := "0.2"

scalaVersion := "2.13.7"

idePackagePrefix := Some("com.rommelrico.testinginscala")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-16" % "3.2.12.0" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.16.0" % "test"
