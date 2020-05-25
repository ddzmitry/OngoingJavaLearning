name := "ScalaTutorial"

version := "0.1"
//https://github.com/Shasidhar/kafka-streaming/blob/master/src/main/scala/com/shashidhar/KafkaFromOffsets.scala
scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "2.2.0",
  "org.apache.spark" %% "spark-sql" % "2.2.0",
  "org.apache.bahir" %% "spark-streaming-akka" % "2.0.1"
)

libraryDependencies += "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
