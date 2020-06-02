package lectures.functionsPart3

object mapFlatMapFilter extends App {


  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map( _ + " is a number"))

  // filter
  println(list.filter(_ %2 == 0))

  // flatMap
  val toPair:Int=>List[Int] = (x: Int) => List(x,x+1)
  println(list.flatMap(toPair))

  // print out all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black","white")
  // a1 , a2 ....d4

  val combinations = numbers.flatMap( n => chars.map(c => "" + c + n))
  println(combinations)

  val combinations_2 = numbers.flatMap( n => chars.flatMap( c => colors.map( color => " " + n + c + "-" + color)))
  println(combinations_2)

  // foreach
  list.foreach(println)

  // for-comprehations
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  val forCombinationsFilter = for {
    n <- numbers if n %2 == 0 // this is filter code
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinationsFilter)

  // for each
  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map {x =>
    x *2
  }

  /*
  1.  MyList supports for comprehensions?
      map(f: A => B) => MyList[B]
      filter(p: A => Boolean) => MyList[A]
      flatMap(f: A => MyList[B]) => MyList[B]
  2.  A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
 */




}
