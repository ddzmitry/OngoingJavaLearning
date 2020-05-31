package lectures.part2OOP

object OOPBasics  extends  App {



    //  val person = new Person("Dz",28)
    //  println(person.age)
    //  person.greet("Fa")

    val authot = new Writer("Charles","Dickens",1812)
    val novel = new Novel("Great Expectations",1861,authot)

    println(novel.authotAge)
    println(novel.isWrittenBy(authot)) // true
    val release2 = novel.copy(1871)
    println(release2.authotAge)


    val counter = new Counter
    counter.inc.print
    counter.inc(3).print
    counter.dec(3).print

  }

  class Counter(val count:Int=0){
    def inc = {
      println("incrementing")
      new Counter(count + 1)  // immutability
    }

    def dec = {
      println("decrementing")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
      if (n <= 0) this
      else inc.inc(n-1)
    }

    def dec(n: Int): Counter =
      if (n <= 0) this
      else dec.dec(n-1)
    def print = println(count)
    //  def inc(n: Int) = new Counter(count + n)
    //  def dec(n: Int) = new Counter(count - n)
  }

  class Person(val name: String, val age: Int){
    // method
    def greet(name: String) : Unit = println(s"${this.name} says, Hello $name")
    // overloading
    def greet(): Unit = println(s"Hi, I am $name")
    // multiple constructors
    def this(name: String) = this(name,0)
  }


  class Writer(firstName: String,surname:String, val year:Int){
    def fullName: String = s"$firstName $surname"
  }
  class Novel(name: String,year:Int, author: Writer){
    def authotAge = year - author.year
    def isWrittenBy(author: Writer) = author == this.author
    def copy(newYear: Int) : Novel = new Novel(name,newYear,author)




  // class parameters are not fields you need put val/var to get it
}
