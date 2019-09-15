
package com.guida.spark.utils

import org.apache.spark.rdd.RDD

object WordCounter {
  def count(lines: RDD[String]): RDD[(String, Int)] = {
    val wordsCount = lines.flatMap(l => l.split("\\W+"))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    wordsCount
  }
}

object myApplication extends sparkSession {

  def main(args: Array[String]) {
    val input: RDD[String] = sc.textFile("src/main/resources/intro.txt")
    val countByWordRdd: RDD[(String, Int)] = WordCounter.count(input)

    countByWordRdd.foreach(println)
  }
}
