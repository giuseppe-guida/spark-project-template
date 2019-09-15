import scala.reflect.runtime.universe._

def getInnerType[T](list:List[T])(implicit tag:TypeTag[T]) = tag.tpe.toString

val stringList: List[String] = List("A")
val stringName = getInnerType(stringList)
println( s"a list of $stringName")

println("Giuseppe")