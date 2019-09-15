
package com.guida.spark.test

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar

case class Person(name: String, age: Long)

class Compute(sc: SparkContext, spark: SparkSession) {

  def addElement(a: RDD[Int]): Long = {

    import spark.implicits._

    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()

    spark.read.parquet("This is a fake path that won't be executed")

    println(":::::::::::::::::::::::::::::::::")
    println("This method class and its method are mocked")
    a.count
  }
  
}

class Executor(computation: Compute, sc: SparkContext, spark: SparkSession) {

  def to(rdd: RDD[Int]): Long = {
    println("++++++++++++++++++++++++++++++++")
    computation.addElement(rdd) + 1
  }

}

class myTest extends sparkTestSession with MockitoSugar {

  it should "count words in a text" in {
    val ComputeMock = mock[Compute]
    val ss = new Executor(ComputeMock, sc, spark)
    val rdd = sc.parallelize(Seq(1))

    when(ComputeMock.addElement(rdd)) thenReturn 1

    assert(ss.to(rdd) === 1 + 1 )
  }
}
