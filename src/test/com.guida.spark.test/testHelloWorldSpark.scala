
package com.guida.spark.test

import com.guida.spark.utils.WordCounter
import org.apache.spark.rdd.RDD

class WordCounterTest extends sparkTestSession {

  behavior of "Words counter"

  it should "count words in a text" in {
    val text =
      """Hello Spark
        |Hello world
      """.stripMargin
    val lines: RDD[String] = sc.parallelize(List(text))
    val wordCounts: RDD[(String, Int)] = WordCounter.count(lines)

    wordCounts.collect() should contain allOf(("Hello", 2), ("Spark", 1), ("world", 1))
  }
}