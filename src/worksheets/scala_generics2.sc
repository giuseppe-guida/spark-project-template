class Stack[A] {
  private var elements: List[A] = Nil

  def push(x: A) {
    elements = x :: elements
  }

  def peek: A = elements.head

  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

val stack = new Stack[Int]
stack.push(1)
stack.push(2)
println(stack.pop) // prints 2
println(stack.pop) // prints 1


class Fruit
class Apple extends Fruit
class Banana extends Fruit

val stackOfFruit = new Stack[Fruit]
val apple = new Apple
val banana = new Banana

stackOfFruit.push(apple)
stackOfFruit.push(banana)
/////////////////////////////////////////
trait DomainEntity{val date: String}
case class Op(name: String, date: String) extends DomainEntity
case class Cp(name: String, date: String) extends DomainEntity



class baseMerge[T<:DomainEntity
] {
  def transform(element: T): List[T] = {
    List[T]()
  }
}

object merge extends baseMerge[Op] {
  def whatAmIDoing(): Unit  = {
    println("Merging")
    val x = Op(name="Giuseppe", date="today")
    transform(x: Op)
  }
}