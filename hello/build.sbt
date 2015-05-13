lazy val root = (project in file(".")).
	settings(
		name := "hello",
		version := "1.0",
		scalaVersion := "2.11.6",
		retrieveManaged := true,
		libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.11"
	)
