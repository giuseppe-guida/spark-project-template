import org.apache.spark.sql.SparkSession
import java.sql.Timestamp
import org.apache.spark.sql.functions.udf

val spark: SparkSession = {
  SparkSession
    .builder()
    .master("local")
    .appName("spark pika")
    .getOrCreate()
}

import spark.implicits._


val dataset = Seq((0, "hello"), (1, "world")).toDF("id", "text")

// Define a regular Scala function
val upper: String => String = _.toUpperCase
val limit = 5-1
val subString: String => String = str => if (str.length > 2) str.slice(0, 3) else str

// Define a UDF that wraps the upper Scala function defined above
// You could also define the function in place, i.e. inside udf
// but separating Scala functions from Spark SQL's UDFs allows for easier testing

import org.apache.spark.sql.functions.udf

val upperUDF = udf(upper)
val subStringUDF = udf(subString)

// Apply the UDF to change the source dataset
dataset.withColumn("upper", upperUDF('text)).show
val x = "text"
dataset.withColumn("subString", subStringUDF(col(x))).show