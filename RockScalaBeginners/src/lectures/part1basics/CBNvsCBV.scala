package lectures.part1basics

object CBNvsCBV  extends  App{

  def calledByValue(x: Long): Unit = {
    println(f"by value $x")
    println(f"by value $x")

  }

  def calledByName(x: => Long) : Unit = {
    // Executes System.nanoTime() once
    println(f"by value $x")
    // Executes System.nanoTime() second time
    println(f"by value $x")
  }

  calledByValue(System.nanoTime())
  // Returns two different values
  calledByName(System.nanoTime())

  def infinent() : Int = 1 + infinent()
  def printFirst(x:Int, y: => Int) = println(x);
  //printFirst(infinent(),34) // Crashes
  printFirst(34,infinent())
}
