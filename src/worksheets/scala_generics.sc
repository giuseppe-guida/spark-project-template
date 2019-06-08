
// A generic linkedlist
// https://alvinalexander.com/scala/scala-classes-using-generic-types-examples

class LinkedList[A] {

  private class Node[A] (elem: A) {
    var next: Node[A] = _
    override def toString = elem.toString
  }

  private var head: Node[A] = _

  def add(elem: A) {
    val n = new Node(elem)
    n.next = head
    head = n
  }

  private def printNodes(n: Node[A]) {
    if (n != null) {
      println(n)
      printNodes(n.next)
    }
  }

  def printAll() { printNodes(head) }

}

// Usage
val ints = new LinkedList[Int]()
ints.add(1)
ints.add(2)
ints.printAll()

val strings = new LinkedList[String]()
strings.add("Nacho")
strings.add("Libre")
strings.printAll()


trait Animal
class Dog extends Animal { override def toString = "Dog" }
class SuperDog extends Dog { override def toString = "SuperDog" }
class FunnyDog extends Dog { override def toString = "FunnyDog" }

val dogs = new LinkedList[Dog]

val fido = new Dog
val wonderDog = new SuperDog
val scooby = new FunnyDog

dogs.add(fido)
dogs.add(wonderDog)
dogs.add(scooby)

