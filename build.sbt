ThisBuild / organization := "com.github.LexDo-it"
ThisBuild / name := "scala-kit"
ThisBuild / version := "2.4.4"

ThisBuild / scalaVersion := "2.13.16"

ThisBuild / resolvers ++= Seq(
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases"
)

ThisBuild / libraryDependencies ++= Seq(
  "org.fluentd" % "fluent-logger" % "0.2.10",
  "org.joda" % "joda-convert" % "1.2",
  "joda-time" % "joda-time" % "2.8.2",
  "io.spray" %% "spray-json" % "1.3.5",
  "com.jcraft" % "jzlib" % "1.1.2",
  "io.netty" % "netty-all" % "4.1.119.Final",
  "org.apache.commons" % "commons-collections4" % "4.0",
  "org.specs2" %% "specs2-core" % "4.5.1" % Test
)

Compile / sourceGenerators += Def.task {
  val file = (Compile / sourceManaged).value / "io" / "prismic" / "Info.scala"
  val versionStr = version.value
  val scalaVersionStr = scalaVersion.value
  val nameStr = name.value

  val content =
    s"""package io.prismic
       |
       |object Info {
       |  val version = "$versionStr"
       |  val scalaVersion = "$scalaVersionStr"
       |  val name = "$nameStr"
       |}
       |""".stripMargin

  IO.write(file, content)
  Seq(file)
}
