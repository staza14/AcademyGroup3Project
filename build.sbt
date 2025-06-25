name := "qacohortproject"

version := "0.1"
scalaVersion := "2.13.12"

resolvers += Resolver.mavenCentral

libraryDependencies ++= Seq(
  "io.cucumber" %% "cucumber-scala" % "8.28.0" % Test,       // Latest stable for Scala 2.13
  "io.cucumber" % "cucumber-junit" % "7.23.0" % Test,         // Compatible with cucumber-scala
  "org.seleniumhq.selenium" % "selenium-java" % "4.33.0",     // Latest stable
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,           // Latest stable
  "junit" % "junit" % "4.13.2" % Test,                        // Still widely used
  "commons-io" % "commons-io" % "2.19.0",                      // Latest stable
  "com.novocode" % "junit-interface" % "0.11"   % Test   // ← required for sbt
)

