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

val xdf = spark.createDataFrame(Seq(
  ("A", 1), ("B", 2), ("C", 3)
)).toDF("name", "cnt")
xdf.filter(($"cnt" > 1) || ($"name" isin ("A","B")))

val lookUpDF = spark.createDataFrame(Seq(("A", 1), ("B", 2))).toDF("name", "cnt")

val l = lookUpDF.select("name").map(r => r(0).asInstanceOf[String]).collect()

val filteronlist = xdf.filter(($"cnt" > 1) || ($"name".isin(l:_*)))

filteronlist.show()
