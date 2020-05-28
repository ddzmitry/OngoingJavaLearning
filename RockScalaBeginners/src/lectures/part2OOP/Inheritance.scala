package lectures.part2OOP



object Inheritance  extends  App {

  // Single class inheritance
  class Animal {
    val creatureType = "wild"
    // private , protected, no modifire
//    protected def eat = println("NOMONOM")
     def eat = println("NOMONOM")
  }

  class Cat extends Animal {

    def crunch: Unit = {
      eat
      println("CRONCH")
    }
  }
  val cat = new Cat
  cat.crunch // will call parent class eat because its protected so cant call directly

  // constructors
  case class Person(name: String , age:Int){
    // super constructor
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)
  val Dz = new Adult("Dz",28,"YES")

  // overriding
  class Dog(override val creatureType: String) extends Animal {

    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  // will call DOG methid eat because it is closest
  unknownAnimal.eat
  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files sealed class Animal {
}
