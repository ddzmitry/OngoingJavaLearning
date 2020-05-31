package lectures.part2OOP

object MethodNotations  extends  App {

  class Person(val name: String, val favMovie: String, val age:Int = 0){
    def likes(movie: String) : Boolean = movie == favMovie
    def hangOutWith(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what e heck? "
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favMovie"
    // Prefix notation
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // Overload the + operator
    def +(person_nick_name: String): Person = new Person(f"${this.name} $person_nick_name",this.favMovie)
    // Add a unary + operator => new person with the age + 1
    def unary_+ : Person = new Person(name, this.favMovie, age + 1)
    // Add a "learns" method in the Person class => "Mary learns Scala"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
    // mary.apply(2) => "Mary watched Inception 2 times"
     def apply(n: Int): String = s"$name watched $favMovie $n times"
  }
  // infix notation = operation notation (syntactic sugar)
  val mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // INFIX NOTATION ONLY WITH METHODS WITH ONE PARAMETER

  // Operators in Scala
  val tom = new Person("Tom","Fight Club")
  println(mary hangOutWith tom)
//  mary.hangOutWith(tom) same

  println(1 +2)
  println(1.+(2)) // same
  // Prefix notation
  val x = -1 // eq 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary) // same as println(mary.unary_!) LOL
  println(mary.unary_!)
  // postfix notation
//  println(mary.isAlive)
//  println(mary isAlive) // same as infix notation
  // apply
  println(mary.apply())// same as mary()
  println(mary())

  val Mary2 = mary.+("The RockStar")
  println(Mary2.name) // Mary The RockStar
  println(Mary2.favMovie)
  val MaryAgePlus = mary.unary_+
  println(MaryAgePlus.age) // 1
  println(MaryAgePlus.learns("JVM")) //Mary is learning JVM
  println(MaryAgePlus.learnsScala) // Mary is learning Scala
  println(MaryAgePlus.apply(5)) // Mary watched Inception 5 times
  println(MaryAgePlus(5)) // Mary watched Inception 5 times

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */
}
