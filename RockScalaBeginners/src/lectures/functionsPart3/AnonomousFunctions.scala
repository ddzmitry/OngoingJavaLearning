package lectures.functionsPart3

object AnonomousFunctions extends App {

  // anonymous  funciton (LAMBDA)
//  val doubler = (x: Int) => x * 2
  val doubler: Int => Int = x => x * 2
  // multiple parameters in lambda

//  val adder = (a:Int,b:Int) => a +b
  val adder:(Int,Int) => Int = (a:Int,b:Int) => a +b
  // no parameter
  val justDoSomething:()=> Int  = () => 3
  println(justDoSomething)
  println(justDoSomething())

  // curly braces
  val stringToInt = { (str:String) =>
    str.toInt
  }
  // Mor synt sugar

//  val niceIncrementer: Int => Int = (x:Int) => x + 1
    val niceIncrementer: Int => Int = _ +1

//  val niceAdder: (Int,Int) => Int = (a:Int,b:Int) => a + b
  val niceAdder: (Int,Int) => Int = _ + _  // each _ is different parameter

  //   val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
  //    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
  //      override def apply(y: Int): Int = x + y
  //    }
  //  }
  // to Anonumous function


//  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
val superAdder = (x: Int) => (y: Int) => x + y


}
