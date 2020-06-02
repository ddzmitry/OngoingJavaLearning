
package lectures.functionsPart3

import lectures.functionsPart3.HOFsAndCurries.fizzBuzzToString

object FLAT_MAP_SUFF  extends App {

  val l = List(10,20,30,50,45,54)
  // FLAT MAP
  val t = l.flatMap(new Function1[Int,List[String]] {
    override def apply(elem: Int): List[String] = {List(fizzBuzzToString(elem),fizzBuzzToString(elem - 1))}

  })
//  println(t)

  println(l.flatMap(x => l.map( y => List(f"The sum of ${y} + ${x} = ${y+x} \n"))))

//  def concatrer: ((String,String) => String )= (a: String, b: String) => a + b

  case class test (val x: Int, val b: String)

  def todo(int: Int) : List[test] = {
    List(test(int,int+" Inside"))
  }
  val output = for {
    item <- l
  } yield todo(item)

  println(output)
}