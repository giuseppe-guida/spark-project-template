import sqlContext.implicits._

case class TestData(banana: String, orange: String, apple : String, feijoa: String)

var data = sc.parallelize((1 to 5).map(i => TestData("banana="+i.toString,
  "orange="+i.toString,"apple="+i.toString,"feijoa="+i.toString))).toDF
data = data.withColumn("combined", array($"banana",$"orange", $"apple",$"feijoa"))
data.show


data =(1 to 5).foldLeft(data){
  (x,i) => x.withColumn(i.toString, getFunc(results(i-1).fruits)($"combined"))
}