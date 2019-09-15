import scala.collection.mutable.Stack

var ints = Stack[Int]()
var fruits = Stack[String]()
case class Person(var name: String)
var people = Stack[Person]()

  ints = Stack(1, 2, 3)

println(ints.pop)
println(ints.pop)
println(ints.pop)