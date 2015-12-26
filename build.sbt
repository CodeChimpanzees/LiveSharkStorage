name := "LiveSharkStorage"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.scalaz" %% "scalaz-core" % "7.2.0",
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
  "com.h2database" % "h2" % "1.4.190"
)

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
