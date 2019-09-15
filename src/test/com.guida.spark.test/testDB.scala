import org.apache.spark.sql.{DataFrame, SparkSession}
import java.sql.{Connection, DriverManager, Timestamp}
import java.util.Properties
import org.apache.spark.sql.functions.udf
import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite}
import org.scalamock.scalatest.MockFactory


//case class Input(jdbcUrl: String, selectQuery: String, columnName: String ="", maxId: String = "", parallelism:String="",
//  connectionProperties:Properties)
//
//class DataManager(session: SparkSession) {
//  def loadFromDatabase(input: Input): DataFrame = {
//    session.read.jdbc(
//      input.jdbcUrl,
//      s"(${input.selectQuery}) T0",
//      input.connectionProperties)
//  }
//}
//
//class DataManagerTest extends FunSuite with BeforeAndAfter {
//
//  def beforeAll() {
//    val conn: Connection = DriverManager.getConnection("jdbc:h2:~/test")
//    // your insert statements goes here
//    conn.close()
//  }
//
//  test ("should load data from database") {
//    val dm: DataManager()
//    val input = Input(jdbcUrl = "jdbc:h2:~/test", selectQuery="SELECT whateveryounedd FROM whereeveryouputit ")
//    val expectedData = dm.loadFromDatabase(input)
//    assert(1==1)
//  }
//}