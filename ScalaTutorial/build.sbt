name := "ScalaTutorial"

version := "0.1"
//https://github.com/Shasidhar/kafka-streaming/blob/master/src/main/scala/com/shashidhar/KafkaFromOffsets.scala
scalaVersion := "2.13.2"

//libraryDependencies += {
//  val version = scalaBinaryVersion.value match {
//    case "2.10" => "1.0.3"
//    case _ ⇒ "1.6.5"
//  }
//  "com.lihaoyi" % "ammonite" % version % "test" cross CrossVersion.full
//}
//
//sourceGenerators in Test += Def.task {
//  val file = (sourceManaged in Test).value / "amm.scala"
//  IO.write(file, """object amm extends App { ammonite.Main.main(args) }""")
//  Seq(file)
//}.taskValue