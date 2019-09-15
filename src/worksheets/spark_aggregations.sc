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

case class FootballPlayer(name: String, age: Int, team: Option[String], birthDate: Timestamp, debutDate: Option[Timestamp], stillPlaying: Some[Boolean], wonTitles: Some[Boolean])

val maybeString = None: Option[String]
val maybeDate = None: Option[Timestamp]

val FootballPlayersDS = Seq(
  FootballPlayer("Totti", 33, Some("Roma"), Timestamp.valueOf("1986-03-11 00:00:00"), Some(Timestamp.valueOf("1990-09-02 03:04:00")), Some(true), null),
  FootballPlayer("Buffon", 43, Some("PSG"), Timestamp.valueOf("1992-01-25 00:00:00"), maybeDate, Some(true), Some(false)),
  FootballPlayer("Muller", 45, maybeString, Timestamp.valueOf("2017-12-02 00:00:00"), Some(Timestamp.valueOf("2001-12-02 03:04:00")), Some(false), Some(true)),
  FootballPlayer("Donnarumma", 45, maybeString, Timestamp.valueOf("2017-12-02 00:00:00"), Some(Timestamp.valueOf("2001-12-02 03:04:00")), null, null),
  FootballPlayer("Lakaku", 45, maybeString, Timestamp.valueOf("2017-12-02 00:00:00"), Some(Timestamp.valueOf("2001-12-02 03:04:00")), Some(false), Some(false))
).toDS()
//FootballPlayersDS.show()

//Same checks on the dataset to export
crossJoinDf.groupBy("ohubid").count()
  .filter($"count" >= 2)
  .show(10, false)