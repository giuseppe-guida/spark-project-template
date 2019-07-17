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


FootballPlayersDS.drop($"team")
val temp = FootballPlayersDS.drop($"team")
temp.show()
FootballPlayersDS.show()

FootballPlayersDS.withColumn("and", $"stillPlaying" && $"wonTitles")
  .withColumn("or", $"stillPlaying" || $"wonTitles")
  .withColumn("nulltest",   !$"wonTitles")
  .show()



// UDF
val c = List("age", "stillPlaying")

def foo = udf(
  (age: Int, stillPlaying: Boolean) => {
    if(age < 35) "young"
    else "old"
})



FootballPlayersDS.withColumn("young?",foo(FootballPlayersDS("age"),FootballPlayersDS("stillPlaying"))).show(false)



def adjustDoubleOptIn = udf(
  (optIn: Boolean, doubleOptIn: Boolean, optOut: Boolean) => {
    val totOptIn: Boolean = optIn || doubleOptIn
    if(optOut == null && totOptIn != null) !totOptIn
    if(totOptIn == null && optOut != null) !optOut
  })

def adjustSingleOptIn = udf(
  (optIn: Boolean, optOut: Boolean) => {
    if(optOut == null && optIn != null) !optIn
    if(optIn == null && optOut != null) !optOut
  })


FootballPlayersDS.withColumn("young?",foo(FootballPlayersDS("age"),FootballPlayersDS("stillPlaying"))).show(false)