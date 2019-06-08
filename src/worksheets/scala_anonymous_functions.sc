/** Functions and Anonimous functions

To understand the difference between val, lazy val, def when defining a function:
https://stackoverflow.com/questions/18887264/what-is-the-difference-between-def-and-val-to-define-a-function

Summary:

|          | evaluation     | isntances created  |
|----------|----------------|--------------------|
| val      | on definition  | only one           |
| lazy val | on first usage | only one           |
| def      | on every usage | one for every call |

  **/

// Functions

val double = (i: Int) => { i * 2 }
double(2)   // 4
double(3)   // 6

val list = List.range(1, 5)
list.map(double)


// The following are all allowed examples

val f: (Int) => Boolean = i => { i % 2 == 0 }
val g: Int => Boolean = i => { i % 2 == 0 }
val h: Int => Boolean = i => i % 2 == 0
val z: Int => Boolean = _ % 2 == 0 // To use the _ it's necessary to define the returned type

// the shortest way would be
// val s: Int => {_ % 2 == 0} // this fails

// Functions Excplicit declaration
val addThenDouble: (Int, Int) => Int = (x,y) => {
  val a = x + y
  2 * a
}

def addInt( a:Int, b:Int ) : Int = {
  var sum:Int = 0
  sum = a + b
  return sum
}



// ANONYMOUS FUNCTIONS
val ints = List(1,2,3) //or  0 until 20
val doubledInts = ints.map(_ * 2)
val x = ints.filter(_ % 5 == 0)
val y = ints.filter((i: Int) => i % 2 == 0)
val zz = ints.filter(i => i % 2 == 0)

zz

/**

or
val doubledInts = ints.map((i: Int) => i * 2)
val doubledInts = ints.map(i => i * 2)
val doubledInts = for (i <- ints) yield i * 2

  **/
