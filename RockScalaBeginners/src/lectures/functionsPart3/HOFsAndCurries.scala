package lectures.functionsPart3


object HOFsAndCurries extends App {

  // function returns a funciton that taks a parameter
//  val superFunction: (Int,(String,(Int => Boolean)) => Int) => (Int => Int) = ???
  // High order function (HOF)
  // map,flatMap, filter

  // funciton tat applies a funciton n times over a value x

  // nTimes(f,n,x)
  // nTimes(f,3,x) => f(f(f(x))) = nTimes(f,2,f(x)) = f(f(f(x)))
  // nTimes(f,n,x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x:Int): Int = {
    if(n <= 0) x
    else nTimes(f,n-1,f(x))
  }

  def plusOne = (x:Int) => x +1
  println(nTimes(plusOne,10,1))
  // ntb(f,n) = x => f(f(f,...(x))))
  // inrement10 = ntb(plusOne,10) =x => plusOne(plusOne...(x))
  // val y = inverment10(1)
  def nTimesBetter (f: Int => Int,n:Int) :(Int => Int) =
    if(n <= 0) (x:Int) => x // return lambda
    else (x:Int) => nTimesBetter(f,n-1)(f(x))

  val plusTen = nTimesBetter(plusOne,10)
  println(plusTen(2)) // 1
  println(plusTen(2)) // 12

  // curied functions
  // same as (x:Int) => (y:Int) => x +y
  val superAdder: Int => (Int => Int)  = (x:Int) => (y:Int) => x +y
  val add3 = superAdder(3) // y => 3 +y
  println(add3(10)) // 10 + 3
  println(superAdder(3)(10))
  // functinos with multible parameter list

  def curriedFormatter(c: String)(x: Double) : String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val perciseFormat: (Double => String) = curriedFormatter("%10.8f")
  println(standardFormat(Math.PI))
  println(perciseFormat(Math.PI))



  // write a function that takes a number and returns a number - 1 and fixx bux on it untill its 0

  def fizzBuzz:(Int => Unit) = (x: Int) => {
    val out =   (if(x % 15 == 0)  "FizzBuzz"
    else if (x % 5 == 0) "Fizz"
    else if (x % 3 == 0) "Buzz"
    else "None")
    println(f"Number is ${x} output is : ${out}")
  }

  def superFizzBuz(f: Int => Unit, n:Int) : Unit = {
    if( n <= 0) return
    else f(n); superFizzBuz(f,n-1)
  }
//  println(superFizzBuz(fizzBuzz,Int.MaxValue))

  def fizzBuzzToString:(Int => String) = (x: Int) => {
    val out =   (if(x % 15 == 0)  "FizzBuzz"
    else if (x % 5 == 0) "Fizz"
    else if (x % 3 == 0) "Buzz"
    else "None")
    out
  }

  // function that takes Ineger and returns String , value , cacher
  def arrayFizz(f: Int => String, v: Int, n: List[String]) : List[String] = {
    if( v <= 0) n
    else arrayFizz(f,v-1,n.appended(f(v)))
  }

  val l = List(10,20,30,50,45,54)

//  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
//    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem+1,Empty))
//  })
//  ).toString

  // FLAT MAP
  val t = l.flatMap(new Function1[Int,List[String]] {
    override def apply(elem: Int): List[String] = {List(fizzBuzzToString(elem),fizzBuzzToString(elem - 1))}

  })
  println(t)

//  println(arrayFizz(fizzBuzzToString,15,List()))





//   def nTimes(f: Int => Int, n: Int, x:Int): Int = {
  //    if(n <= 0) x
  //    else nTimes(f,n-1,f(x))
  //  }



  /*
   1.  Expand MyList
       - foreach method A => Unit
         [1,2,3].foreach(x => println(x))
       - sort function ((A, A) => Int) => MyList
         [1,2,3].sort((x, y) => y - x) => [3,2,1]
       - zipWith (list, (A, A) => B) => MyList[B]
         [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]
       - fold(start)(function) => a value
         [1,2,3].fold(0)(x + y) = 6
   2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
       fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
   3.  compose(f,g) => x => f(g(x))
       andThen(f,g) => x => g(f(x))
  */

def toCurry(f:(Int,Int) => Int) : (Int => Int => Int) = x => y => {f(x,y)}
def fromCurry(f: (Int => Int => Int)) : (Int, Int) => Int = (x,y) => {f(x)(y)}
// Funcion x
//  def compose(f: Int => Int, g: Int => Int) : Int => Int = x => f(g(x))
//def andThen(f: Int => Int, g: Int => Int ) : Int => Int = x => g(f(x))
def compose[A,B,T](f: A => B, g: T => A) : T => B = x => f(g(x))
def andThen[A,B,C](f: A => B, g: B => C ) : A => C = x => g(f(x))

def superAdder2:(Int => Int => Int) = toCurry((_+_))
println(superAdder2(2)(5)) // 7
def add4 = superAdder2(4) // ++4
println(add4(17)) // 21

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17)) //21

  val add2 = (x: Int) => x +2
  val times3 = (x: Int) => x *3

  // f: A => B is add2 | g: T => A is times3 |  2(+4(* 3)) = 14
  val composed = compose(add2,times3)
  // f: A => B is add2 | g: T => A is times3 | 3*((2) +4 )) = 18
  val ordered = andThen(add2,times3)
  println(composed(4))
  println(ordered(4))

}
