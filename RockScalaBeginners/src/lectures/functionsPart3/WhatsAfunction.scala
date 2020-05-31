package lectures.functionsPart3

object WhatsAfunction extends App {

  // DREAM : use functions as first class elements
  // Problem OOP

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element *2
  }

  println(doubler(5))

  // functon types = Function1[A,B] - Takes parameter String and Returns Integer
  val stringToInt = new Function[String,Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToInt("1"))
  // Takes INT, INT and returns INT
  val adder: ((Int,Int) =>Int) = new Function2[Int,Int,Int] {
    override def apply(a: Int, b: Int): Int = a +b
  }
  println(adder(4,5))

  // function types Function2[A,B,R] === (A,B) => R
  // ALL SCALA FUNCTIONS ARE OBJECTS

//  def concatrer: ((String,String) => String )=  new Function2[String,String,String]{
//  override def apply(a: String,b: String) : String = a +b
//  }
  def concatrer: ((String,String) => String )= (a: String, b: String) => a + b
  println(concatrer("Hello","World"))




  //  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
  //    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem+1,Empty))
  //  })
  //  ).toString

  // Flat map test
  val l =  List("Hello","World","Test","Poop")
  val testMap = l.flatMap( new Function[String, List[String]] {
    override def apply(elem: String) : List[String] = {
      List(elem.toLowerCase(),elem.toUpperCase)
    }
  })
  println(testMap.toString())
  // define a function which takes and int and returns another function which taks an int and return int
  // Function1[Int,Function[Int,Int]]

//  val specialFunciton: Function1[Int, Function1[Int,Int]] = new Function1[ Int, Function1[Int,Int]] {
//     override def  apply(x: Int) : Function1[Int,Int] = new Function1[Int,Int] {
//       override def apply(y: Int) : Int = x + y
//    }
//  }
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function
}

trait MyFunction[A,B] {
  def  apply(element: A) : B = ???
}
