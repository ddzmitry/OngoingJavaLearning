package lectures.part1basics

object StringOps extends App {

  val str:String = "Hello, I am learning Scala"
  // l
  println(str.charAt(2))
  // I am
  println(str.substring(7,11))
  // List
  println(str.split(" ").toList)
  // true
  println(str.startsWith("Hello"))
  //
  println(str.replace(" ","-"))

  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length())
  val anumberString = "45"
  val aNumber = anumberString.toInt
  // Prepending a45z
  println('a' +: anumberString :+ 'z')

  println(anumberString.reverse)
  // He
  println(anumberString.take(2))

  // Scala-Specific
  // S-interpolators
  val name = "Dzmitry"
  val age  = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)
  val greeting2 = s"Hello, my name is $name and I will be ${age + 1} years old"
  println(greeting2)
  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per min"
  println(myth)

  // raw-interpolators
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  // will ad /n
  println(raw"$escaped")
}
