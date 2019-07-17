
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


case class t(a: Int, b: Int)
val df = Seq(t(1,2), t(3,4), t(1,5), t(1,6), t(1,5), t(1,9)).toDS()

object TupleUDFs {
  import org.apache.spark.sql.functions.udf
  // type tag is required, as we have a generic udf
  import scala.reflect.runtime.universe.{TypeTag, typeTag}

  def toTuple2[S: TypeTag, T: TypeTag] =
    udf[(S, T), S, T]((x: S, y: T) => (x, y))
}

df.withColumn(
  "tuple_col", TupleUDFs.toTuple2[Int, Int].apply(df("a"), df("b"))
).show()

df.withColumn("combined", struct("a","b"))
  .groupBy("a").agg(collect_list("combined").as("combined_list"))

val dfm = df.withColumn("combined", struct("a","b"))
  .groupBy("a").agg(collect_list("combined").as("combined_list"))

dfm.columns


val dff = Seq(t(1,2), t(3,4), t(1,5), t(1,6), t(1,5), t(1,9)).toDS()
val df2 = dff.map(x ⇒ x.a -> x).show()

val dfff =
  Seq((1,2), (3,4), (1,5)).toDS()
val df3 = dfff.map(pair => (pair._1, (pair._1, pair._2)))
//contactPersons
//  .map(x ⇒ x.ohubId.get -> x)
//  .toDF("ohubId", "contactPerson")
//  .groupBy("ohubId")
//  .agg(collect_list($"contactPerson").as("contactPersons"))
//  .as[(String, Seq[ContactPerson])]
//  .map(_._2)
//  .flatMap(markGoldenRecord(sourcePreference))