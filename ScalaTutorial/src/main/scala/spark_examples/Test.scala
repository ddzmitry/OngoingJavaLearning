package spark_examples

import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test {
  def main(args: Array[String]): Unit = {

    val ssc = new StreamingContext("local[*]", "PrintTweets", Seconds(1))

    ssc.start()
    ssc.awaitTermination()
  }
}
