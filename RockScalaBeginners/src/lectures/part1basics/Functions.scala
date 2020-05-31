package lectures.part1basics

import scala.annotation.tailrec

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
    if(num <= 1) 1 else num * factorial(num-1)
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

  def isPrime(n: Int) : Boolean = {
// Aux function
    def isPrimeUnitl(t: Int) : Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUnitl(t-1)
    }
    isPrimeUnitl(n/2)
  }
  println(isPrime(5))

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3, ""))


  def isPrime2(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime2(2003))
  println(isPrime2(629))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
