package lectures.part2OOP

object CaseClasses  extends  App{

 /*
 *  equals , hashCode , to string
 * */

  case class Person(name: String, age: Int)

  // 1. Class parameters promoted to fields

  val jim = Person("Jim",34)
  println(jim.name)

  //
  println(jim.toString)

  //2. eqials and hashCode impemented Out of the BOx
  val jim2 = new Person("Jim",34)
  println(jim == jim2)
  // 3. Case Classes handy copy
  val jim3 = jim.copy(age = 45)
  println(jim3) // "Jim" 45

  // 4 Case classes have companion objects
  val the_person = Person
  val mary = Person.apply("Mary",23) // Person("Mary",23)

  // 5 CCs are serializable

  // 6 CCS have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    // each param is a case class
    def name: String = "The UK of GB and NI"
  }



}
