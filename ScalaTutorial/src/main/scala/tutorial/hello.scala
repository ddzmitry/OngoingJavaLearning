package tutorial

object hello {

  def main(args: Array[String]): Unit = {

    val numberList = List(1, 2, 3, 4, 5)              //> numberList  : List[Int] = List(1, 2, 3, 4, 5)
    val fraction = numberList.reduce( (x: Int, y: Int) => ((x*y)))
    println(f"The value is: $fraction")

   val List2 = List();
//    for (x <- 1 to 40) {
////      println(x)
//      List2.appended(x)
//    }

//    val l2 = List2.map((x:Int)=>{
//      println(x)
//      (x%3,x%5)
//    })
//    l2.foreach(println)
//
//    (1 until 1000000).map(i => (i % 3, i % 5) match {
//      case (0, 0) => "FizzBuzz"
//      case (0, _) => "Fizz"
//      case (_, 0) => "Buzz"
//      case _ => i
//    }).foreach(println)
  }
}
