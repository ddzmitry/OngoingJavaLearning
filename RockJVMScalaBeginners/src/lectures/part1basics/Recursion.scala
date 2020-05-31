package lectures.part1basics

import lectures.part1basics.Functions.factorial

object Recursion  extends  App {


  def factorial(num: Int): Int ={
    if(num <= 1) 1
    else {

      val result = num * factorial(num-1)
    }
  }
}
