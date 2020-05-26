package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // Expression
  println(x)
  println(2 + 3 * 4)
  // == != > >= < <=

  println(!(1== x))
  // ! && ||
  var aVariable = 2
  aVariable +=3
  println(aVariable)

  // Instructions (Computer to DO) vs Expressions (VALUE)

  // If Expression

  val aCondtion = true
  val aConditionedValue = if(aCondtion) 5 else 3 // If true is 5 else it's 3
  println(aConditionedValue) // 5

  // Loops
  var i =0
  // IMPERITIVE Dont write that way
  while (i<10){
    println(i)
    i+=1
  }

  val aWeirdValue = (aVariable = 3) // Unit === Void
  println(aWeirdValue)
  // side effects : println(), whiles m reassigning

  // Code Blocks
  val aCodeBlock = {
    val y =2
    val z = y +1
    if (x>2) "hello" else "goodbye"
  }
  println(aCodeBlock) // "hello"

  // challange
  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  println(f"someValue: $someValue SomeOtherValue: $someOtherValue")
}
