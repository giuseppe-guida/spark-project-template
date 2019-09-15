
// Match case
import scala.util.Random

val x: Int = Random.nextInt(10)
x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}

// Match case as a function
def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}

val dateUpdated = true
val dateCreated = false

def f(input: Int): Unit = println("whatever")
def g(input: Int): Unit = println("biddimasd")
val gg = 1

val conditionDates = dateUpdated&&dateCreated

(dateUpdated, dateCreated) match {
  case (true, false) if dateCreated==dateUpdated => f(gg)
  case (false, false) => g(gg)
  case _ => "other"
}

val a = true
val b = true
val c = false

val condition1 = a&&b
val condition2 = a||b

condition1 match {
  case true if dateCreated==dateUpdated => f(gg)
  case true if dateCreated!=dateUpdated => f(gg)
  case false => g(gg)
  case _ => "other"
}


println(a&&b)


//1) o1.DU && o2.DU aka true and true
//2) o1.DU && !o2.DU aka true and false
//3) !o1.DU & !o2.DU & o1.DU == o2.DU
//4) !o1.DU & !o2.DU & o1.DU != o2.DU

(dateUpdated, dateCreated ,) match {
  case (true, false ) => fid(gg)
  case (false, false) => g(gg)
  case _ => "other"
}


//
//println(matchTest(3))
//
//
//// Match case by type
//println(matchTest("two"))
//println(matchTest("test"))
//println(matchTest(1))
//
//def matchTest(x: Any): Any = x match {
//  case x: String => "scala.String"
//  case x: Int => "scala.Int"
//  case _ => "many"
//}
//
//// Match by classes
//case class Person(name: String, age: Int)
//
//val alice = new Person("Alice", 25)
//val bob = new Person("Bob", 32)
//val charlie = new Person("Charlie", 32)
//
//for (person <- List(alice, bob, charlie)) {
//  person match {
//    case Person("Alice", 25) => println("Hi Alice!")
//    case Person("Bob", 32) => println("Hi Bob!")
//    case Person(name, age) => println(
//      "Age: " + age + " year, name: " + name + "?")
//  }
//}
//
//
//// Match case by function
//val f: (String) => Boolean = i => {
//  if (i == "Peppe") true else false
//}


df
removeCol(df) => df2
replaceDate(removeCol(df)) => df3