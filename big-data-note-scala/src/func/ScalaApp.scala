package func

import scala.math.ceil

/**
 * 在 Scala 中函数是一等公民，这意味着不仅可以定义函数并调用它们，还可以将它们作为值进行传递：
 */
object ScalaApp extends App {
  // 将函数 ceil 赋值给变量 fun,使用下划线 (_) 指明是 ceil 函数但不传递参数
  val fun = ceil _
  println(fun(2.3456)) //输出 3.0

  // 在 Scala 中你不必给每一个函数都命名，如 (x: Int) => 3 * x 就是一个匿名函数：
  // 1. 匿名函数
  (x: Int) => 3 * x
  // 2. 具名函数
  val fun2 = (x: Int) => 3 * x
  // 3. 直接使用匿名函数
  val array01 = Array(1, 2, 3).map((x: Int) => 3 * x)
  // 4. 使用占位符简写匿名函数
  val array02 = Array(1, 2, 3).map(_ * 3)
  // 5. 使用具名函数
  val array03 = Array(1, 2, 3).map(fun2)

  // 可变长度参数列表：在 Java 中如果你想要传递可变长度的参数，需要使用 String ...args 这种形式，Scala 中等效的表达为 args: String*。
  def echo(args: String*): Unit = {
    for (arg <- args) println(arg)
  }

  echo("spark", "hadoop", "flink")

  // 传递具名参数：向函数传递参数时候可以指定具体的参数名。
  def detail(name: String, age: Int): Unit = println(name + ":" + age)

  // 1.按照参数定义的顺序传入
  detail("heibaiying", 12)
  // 2.传递参数的时候指定具体的名称,则不必遵循定义的顺序
  detail(age = 12, name = "heibaiying")

  // 默认值参数：在定义函数时，可以为参数指定默认值。
  def detailDefault(name: String, age: Int = 18): Unit = println(name + ":" + age)
  // 如果没有传递 age 值,则使用默认值
  detailDefault("Carter")
  detailDefault("Carter", 12)
}
