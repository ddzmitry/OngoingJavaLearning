package lectures.part2OOP

object AbstractDataTypes  extends App {

  // abstract class CAN't be instanciated
  abstract  class Animal {
    val creatureType : String
    def eat: Unit
  }
  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }
  // traits
  trait Carnivore {
    // abstract
    def eat(animal: Animal) : Unit
    def preferedMeal: String = "fresh meat"
  }
  trait ColdBlooded
  class crocodail extends Animal with Carnivore with ColdBlooded {
    // From animal
    val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    // From Carnivore
    def eat(animal: Animal): Unit = println(s"I am $creatureType and I am eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new crocodail
  croc.eat(dog) // I am Croc and I am eating Canine

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters trait Carnivore(name:String) // NOT GONNA WORK
  // 2 - multiple traits may be  inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
  // scala.AnyRef .... can be used
}
