package lectures.part2OOP

object Exceptions  extends App {

    val x:String = null
//  println(x.length) will crash with null pointer
  // throwing and catching exceptions

//  val aWeirdValue = throw new NullPointerException

  // throwable classes extend the throwable class
  // exceptions and error are the major Throwable subtypos

  // 2. Catching Exceptions

  def getInt(withExceptions:Boolean) : Int = {
    if(withExceptions) throw  new RuntimeException("No int for you")
    else 42
  }

  val potential_fail = try{
    // code that my fail
    getInt(true)
  } catch {
    case e: RuntimeException => 43
    // println("Caught a runtime exception")
  } finally {
    // code that will executed NO MATTER WHAT
    // finally does not influences return
    // use finally only for sideefects
    println("Finally")
  }

println(potential_fail) // 43

  // how to define your own exceptions

//  class MyException extends  Exception
//  val exception = new MyException
//  throw exception


  //  OOM
  //  val array = Array.ofDim(Int.MaxValue)

  //  SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
