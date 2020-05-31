package lectures.part2OOP

object Generics  extends  App {
  // generic type
  class MyList[+A] {
    // use type A
//    def add(element: A) : MyList[A] = ??? // NOPE
    // B super-type of A will turn into list of B
    def add[B >: A](element: B) : MyList[B] = ???
    /*
    *  A = Cat
    *  B = Animal
    * Will turn into list of Animals if Dog added
    * */
  }
  // can definde what to pass as the value
  class myMap[Key,Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrigs = new MyList[String]
  // Generic Methods
  object MyList {
    // pass the generic to method and generate new class with type of what needed
    def empty[A] : MyList[A] = ???

  }

  val emptyListOfIntegers = MyList.empty[Int] //Pattern: emptyListOfIntegers: Generics.MyList[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class  CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD question

  // 2. NO INVARIANCE
  class InvariantList[A]
  //  val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] NOT GONNA WORK
  val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell No CONTROVARIANCE opposite relationship
  class ContravariantList[-A]
  val   ContravarianAnimalList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  // LOL trainer can not only train just cats but also all types of animals
  val   trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types - only for certain type of class
  class Cage[A <: Animal] (animal: A) // ONLY ACCEPTS ANIMAL
  val cage = new Cage(new Dog)
  class Car
//  val NewCage = new Cage(new Car) NOT GONNA WORK


}
