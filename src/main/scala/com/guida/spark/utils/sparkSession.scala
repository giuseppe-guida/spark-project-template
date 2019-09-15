
package com.guida.spark.utils

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

trait sparkSession {
  val sparkConf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("spark-testing-example")
  val sc = new SparkContext(sparkConf)
  val spark: SparkSession = new SQLContext(sc).sparkSession

}
