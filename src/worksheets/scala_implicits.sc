// From https://madusudanan.com/blog/scala-tutorials-part-28-getting-started-with-implicits/

val value = 10

implicit val anotherValue = 2

def multiply(implicit param1: Int) = param1 * value

//Prints 20
println(multiply)

// Once we declare the first parameter as implicit, anything that follows it is also implicit.
/*
Usually there will be only one implicit parameter for a method. We cannot call param2 directly here since it is implicit.
It also not possible to make the second parameter implicit. Such a syntax would lead to a compiler error.
*/
def multiply2(implicit param1: Int,param2 : Int) = param1 * param2

println(multiply2)


// Implicit functions - Automatic conversions
// Automatic c


implicit def doubleToInt(d: Double) = d.toInt

val x : Int = 20.23

//Prints 20
println(x)

// This currying
def curryingMultiply(myvalue: Int)(param1: Int) = param1 * myvalue
def foo = curryingMultiply(myvalue = 1)
println(foo(3))
println(curryingMultiply(myvalue=1)(param1=3))


// This currying
def curryingPlusImplicitMultiply(myvalue: Int)(implicit param1: Int) = param1 * myvalue
def bar = curryingMultiply(myvalue = 1)
println(bar(3)) // implicit value picked from the scope
println(curryingPlusImplicitMultiply(myvalue=1)) // same as the line before
