package playground
//https://github.com/rockthejvm/scala-beginners
object ScalaPlayground extends App{

  case class Test (name: String, age: Int)

  val Dzmitry = Test("Dzmitry",28)
  Dzmitry.toString

  val t = Some(Dzmitry)
  println(t.value.age)

  val unknownVals = List(11,"Test",22,56,Dzmitry).map(x=> Some(x))
  println(unknownVals)
  def getClassAsString(x: Some[Any]): String = x.value match {
    case s: String => s + " is a String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: List[_] => "List"
    case p: Test => "Person"
    case _ => "Unknown"
  }
  val definirtions = unknownVals.map(x => getClassAsString(x))
  println(definirtions) // List(Int, Test is a String, Int, Int, Person)
}
