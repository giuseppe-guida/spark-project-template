import org.apache.spark.sql.functions.col
import org.apache.spark.sql.SparkSession
import java.sql.Timestamp
// This mechanism wil be deployed to prod, we still have to double check on QA though.

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import java.sql.Timestamp

val spark: SparkSession = {
  SparkSession
    .builder()
    .master("local")
    .appName("spark pika")
    .getOrCreate()
}

import spark.implicits._


case class Person(name: String, age: Int, personid : Int)

case class Profile(name: String, personid  : Int , profileDescription: String)

val df1 = spark.createDataFrame(
  Person("Bindu",20,  2)
    :: Person("Raphel",25, 5)
    :: Person("Ram",40, 9):: Nil)


val df2 = spark.createDataFrame(
  Profile("Spark",2,  "SparkSQLMaster")
    :: Profile("Spark",5, "SparkGuru")
    :: Profile("Spark",9, "DevHunter"):: Nil
)

// you can do alias to refer column name with aliases to  increase readablity

val df_asPerson = df1.as("dfperson")
val df_asProfile = df2.as("dfprofile")


val joined_df = df_asPerson.join(
  df_asProfile
  , Seq("personid") // In this way only one column between two keys is retained
//  , col("dfperson.personid") === col("dfprofile.personid")
  , "inner")

joined_df.show()
//joined_df.select(
//  col("dfperson.name")
//  , col("dfperson.age")
//  , col("dfprofile.name")
//  , col("dfprofile.profileDescription"))
//  .show