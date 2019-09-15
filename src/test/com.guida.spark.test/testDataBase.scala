
package com.guida.spark.test

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession, SaveMode}
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar

case class Player(name: String, age: Long)
case class DBConfig(jdbcDriverClass:String = "com.databricks.spark.sqldw", dbUrl: String, dbTable:String, userName: String, userPassword:String, dbTempDir:String)

trait Storage {
  def writeAzureDWTable(df: DataFrame ): Int
  def writePostGresTable(df: DataFrame ): Int
}

class DefaultStorage(spark: SparkSession) extends Storage {
  def writeAzureDWTable(df: DataFrame ): Int = {
    print("inside AzureDW Writer")
    import spark.implicits._

    val aPerson = Seq(Person("Andy", 32)).toDS
    aPerson.show()

    val dBConfig = DBConfig(dbUrl = "xxx", dbTable = "xxx", userName = "xxx", userPassword = "xxx", dbTempDir = "xxx")

    df.write
      .format(dBConfig.jdbcDriverClass)
      .option("forwardSparkAzureStorageCredentials", "true")
      .option("dbTable", dBConfig.dbTable)
      .option("tempDir", dBConfig.dbTempDir)
      .option("maxStrLength", 4000)  // scalastyle:ignore
      .mode(SaveMode.Overwrite)
      .save

    1
  }
  def writePostGresTable(df: DataFrame ): Int = {
    print("inside PostGresWriter")
    1
  }
}

class BigDataCalculator(spark: SparkSession, storage: Storage) {

  private def preProcess(dataFrame: DataFrame): DataFrame = {
    dataFrame
  }

  def makeBigDataGreatAgain(spark: SparkSession, dataFrame: DataFrame, storage: Storage): Int = {
    import spark.implicits._

    val anotherPerson = Seq(Person("Andy", 32)).toDS() // Do something with dataframes

    val result = storage.writeAzureDWTable(preProcess(dataFrame))

    result
  }
}

class myStorageTest extends sparkTestSession with MockitoSugar {
  import spark.implicits._

  it should "mock the call to the Storage writer. So that the database call doesn't happen" in {
    val StorageMock = mock[DefaultStorage]
    val bigData = new BigDataCalculator(spark, StorageMock)

    val anotherPerson = Seq(Person("Andy", 32)).toDF()

    when(StorageMock.writeAzureDWTable(anotherPerson)) thenReturn 1

    assert(bigData.makeBigDataGreatAgain(spark, anotherPerson, StorageMock) === 1 )
  }
}
