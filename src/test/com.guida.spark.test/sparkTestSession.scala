
package com.guida.spark.test

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

trait sparkTestSession extends FlatSpec with Matchers with BeforeAndAfter {

  val sparkConf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("guida")
  val sc = new SparkContext(sparkConf)
  val spark: SparkSession = new SQLContext(sc).sparkSession

  after {
    sc.stop()
  }
}
