package lectures.part2OOP

import playground.{Cinderella => Princess}

import scala.collection.mutable
import java.sql.{Date => SQLDate}
object PackagingAndImport  extends App {
  // package member accessable by their simple name
  val writer = new Writer("Dz","Docs",2018)
  // import the package
  val princess = new Princess

  // package object

  val date = new SQLDate(2020,5,30)

//  val colors = scala.collection.immutable.Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
//  val colors2 = scala.collection.mutable.Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
//  println(colors.keySet.toList.toString())
//
//  val nums: Map[Int, Int] = Map()
//
//  println( "Keys in colors : " + colors.keys )
//  println( "Values in colors : " + colors.values )
//  println( "Check if colors is empty : " + colors.isEmpty )
//  println( "Check if nums is empty : " + nums.isEmpty )

}
