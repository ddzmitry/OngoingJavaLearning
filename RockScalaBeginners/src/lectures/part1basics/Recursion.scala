package lectures.part1basics

import lectures.part1basics.Functions.factorial

import scala.annotation.tailrec

object Recursion  extends  App {


  def factorial(num: Int): Int ={
    if(num <= 1) 1
    else {
      println(f"Computing factorial of $num - I First need factorial of ${num-1}")
      val result = num * factorial(num-1)
      println(f"Computed factorial of $num ")
      result
    }
  }
//  factorial(50)

  def anotherFactorial (n: Int) : Long = {
    @tailrec
    def factHelper(x: Int, accumulator: Int) : Int = {
      if(x <= 1) accumulator
      else  factHelper(x-1,x*accumulator) // TAIL RECURSION = use recursive call at the LAS expression
    }
    factHelper(n,1)
  }
//  println(anotherFactorial(5000))
  // Contac a string n times
  def concatString(aString:String, aNumber:Int): String ={
    @tailrec
    def concatStringHelper(accumulator:String, aNum:Int) : String={
      if(aNum <= 1) accumulator
      else concatStringHelper(accumulator.concat(aString),aNum-1)
    }

    concatStringHelper(aString,aNumber)
  }
  println(concatString("hello",5))


  // IsPrime function tail recursive
  // Fibonacci tail recursion
}
