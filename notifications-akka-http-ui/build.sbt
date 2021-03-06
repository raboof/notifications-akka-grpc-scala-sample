import akka.grpc.gen.scaladsl.{ScalaBothCodeGenerator, ScalaClientCodeGenerator}

enablePlugins(AkkaGrpcPlugin)

scalaVersion := "2.12.4"

val akkaVersion = "2.5.11"
val akkaHttpVersion = "10.1.1"

akkaGrpcCodeGenerators in Compile := GeneratorAndSettings(ScalaBothCodeGenerator, (akkaGrpcCodeGeneratorSettings in Compile).value) :: Nil

// to debug TLS issues:
// javaOptions in run += "-Djava.util.logging.config.file=src/main/resources/grpc-debug-logging.properties"
// fork in run := true
// connectInput in run := true

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  // To get access to some dummy cert etc for now
  "io.grpc" % "grpc-testing" % "1.11.0"
)