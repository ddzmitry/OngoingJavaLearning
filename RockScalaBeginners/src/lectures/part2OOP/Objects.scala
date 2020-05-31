package lectures.part2OOP

object Objects  extends App {

// SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
  // "static"/"class" - level functionality
  val N_EYES = 2
  def canFly: Boolean = false

  // factory method to build person
  def apply(mother: Person, father: Person): Person = new Person("Bobbie")
}
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS CLASSES WITH OBJECTS will resite in class or object


  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETONE INSTANCE
  val mary = new Person("Mary") // calls class
  val john = new Person("John")
  println(mary == john) // false

  val peter =  Person // calls object
  val alex =  Person // calls object
  println(peter == alex) // true

  val bobbie = Person(mary, john) // same as apply()

  // Scala Applications = Scala object
  // def main(args: Array[String]) : Unit // A MUST



}
