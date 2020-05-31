package lectures.functionsPart3

import lectures.functionsPart3.HOFsAndCurries.fizzBuzzToString

object FLAT_MAP_SUFF {

  val l = List(10,20,30,50,45,54)
  // FLAT MAP
  val t = l.flatMap(new Function1[Int,List[String]] {
    override def apply(elem: Int): List[String] = {List(fizzBuzzToString(elem),fizzBuzzToString(elem - 1))}

  })
  println(t)
}
