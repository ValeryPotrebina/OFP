trait Adder[T]{
  def calc(a: T, b: T): T
}
object Adder{
  implicit def int_adder[T](implicit integral: Integral[T]): Adder[T] =
    new Adder[T] {
      def calc(a: T, b: T): T = integral.plus(a, b)
    }
  implicit def str_adder[T]: Adder[String] =
    new Adder[String] {
      def calc(a: String, b: String): String = a + b
    }
}

class Fibb[T](first: T, second: T){
  val curr = first
  val next = second

  def next()(implicit adder: Adder[T]): Fibb[T] = new Fibb[T](next, adder.calc(curr, next))

  def get(): T = curr
}

println("----FIB INT----")
var fibb_int = Fibb[Int](1, 1)
println(fibb_int.get())
var fibb_int1 = fibb_int.next()
println(fibb_int1.get())
var fibb_int2 = fibb_int1.next()
println(fibb_int2.get())
var fibb_int3 = fibb_int2.next()
println(fibb_int3.get())
var fibb_int4 = fibb_int3.next()
println(fibb_int4.get())
println("---------------")


println("----FIB STR----")

var fibb_str = Fibb[String]("a", "b")
println(fibb_str.get())
var fibb_str1 = fibb_str.next()
println(fibb_str1.get())
var fibb_str2 = fibb_str1.next()
println(fibb_str2.get())
var fibb_str3 = fibb_str2.next()
println(fibb_str3.get())
var fibb_str4 = fibb_str3.next()
println(fibb_str4.get())
println("---------------")
