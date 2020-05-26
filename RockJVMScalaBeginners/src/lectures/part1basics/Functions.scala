package lectures.part1basics

object Functions extends  App {

  def aFunction(a: String, b: Int ) : String = {
    a + " " + b
  }

  println(aFunction("Hello" , 42))

  def aRepeatedValue(aString: String , n : Int) : String  = {
    if (n == 1) aString
    else aString + aRepeatedValue(aString, n-1)
  }

  println(aRepeatedValue("Hello",7))



// VOID functinon
def aFunctionWithSideefects(aString: String) : Unit = println(aString)

  def aBigFunction(n: Int): Int  ={
  def asmallFUnciton (a: Int, b:Int) : Int = a + b
    // run function within a function
    asmallFUnciton(n,math.pow(n,5).toInt)
  }
  println(aBigFunction(10))

  def greating(name:String, Age:Int) : Unit = println(f"Hello my name is $name my age is $Age")

  // challanges
  def factorial(num: Int): Int ={
    if(num <= 1) num else num * factorial(num-1)
  }
  // 3*2*1 = 6
  // 4 * 3 *2 *1 = 24
  println(factorial(3))
  println(factorial(4))

  // fib(n-1) + fib(n-2)
  def fib( n: Int) : Int = {
    n match {
      case 0 | 1 => n
      case _ => fib(n -1) + fib(n-2)
    }
  }
  println(fib(10))
}
