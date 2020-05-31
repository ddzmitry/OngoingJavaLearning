package lectures.part2OOP

object AnonymousClasses  extends  App {

  abstract class Animal {
    def eat: Unit
  }
  // override method when instanciating class

  // anonimous class
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("HAHAHAHHAAHHH")
  }
  /*
  like
  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("HAHAHAHHAA HHH")
  }
  * */
  println(funnyAnimal.getClass) // class lectures.part2OOP.AnonymousClasses$$anon$1

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }
  // anonimous classes work for abstract classes as well as for regular classes
  // make sure to pass parameters
  // and overwrite, implement all fields
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I help?")
  }
}
