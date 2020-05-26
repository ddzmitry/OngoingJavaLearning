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





}
