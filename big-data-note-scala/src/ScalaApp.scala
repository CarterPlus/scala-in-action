import java.io.{FileNotFoundException, FileReader}
import scala.io.StdIn

object ScalaApp extends App {
  // Scala 中的 if/else 语法结构与 Java 中的一样，唯一不同的是，Scala 中的 if 表达式是有返回值的。
  val x = "scala"
  val result1 = if (x.length == 5) "true" else "false"
  println(result1)

  // 在 Scala 中，可以使用 {} 块包含一系列表达式，块中最后一个表达式的值就是块的值。
  val result2 = {
    val a = 1 + 1;
    val b = 2 + 2;
    a + b
  }
  println(result2)
  // 如果块中的最后一个表达式没有返回值，则块的返回值是 Unit 类型。
  val result3 = {
    val a = 1 + 1;
    val b = 2 + 2
  }
  println(result3)

  // Scala 和大多数语言一样，支持 while 和 do ... while 表达式。
  var n = 0
  while (n < 10) {
    print(n + " ")
    n += 1
  }
  println()
  /*do {
    println(n)
  } while (n > 0)*/

  // for 循环的基本使用如下：
  // 1.基本使用  输出[1,9)
  for (n <- 1 until 10) print(n + " ")
  println()
  // 2.使用多个表达式生成器  输出: 11 12 13 21 22 23 31 32 33
  for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d ")
  println()
  // 3.使用带条件的表达式生成器  输出: 12 13 21 23 31 32
  for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d ")
  println()

  // 除了基本使用外，还可以使用 yield 关键字从 for 循环中产生 Vector，这称为 for 推导式。
  val result4 = for (i <- 1 to 10) yield i * 3
  println(result4)

  // 和 Java 中一样，支持 try...catch...finally 语句。
  try {
    val reader = new FileReader("wordCount.txt")
  } catch {
    case ex: FileNotFoundException =>
      //      ex.printStackTrace()
      println("没有找到对应的文件!")
    case _ =>
      println("其它异常")
  } finally {
    println("finally语句总会被执行的")
  }

  // match 类似于 java 中的 switch 语句。
  val elements = Array("A", "B", "C", "D", "E")
  for (elem <- elements) {
    elem match {
      case "A" => print(10 + " ")
      case "B" => print(20 + " ")
      case "C" => print(30 + " ")
      case _ => print(50 + " ")
    }
  }
  println()
  // 在 Scala 中 match 语句是有返回值的，而 Java 中 switch 语句是没有返回值的。如下：
  for (elem <- elements) {
    val score = elem match {
      case "A" => 10
      case "B" => 20
      case "C" => 30
      case _ => 50
    }
    print(elem + ":" + score + "; ")
  }
  println()

  // 在 Scala 中可以使用 print、println、printf 打印输出，这与 Java 中是一样的。如果需要从控制台中获取输入，则可以使用 StdIn 中定义的各种方法。
  val name = StdIn.readLine("Your name: ")
  print("Your age: ")
  val age = StdIn.readInt()
  println(s"Hello, ${name}! Next year, you will be ${age + 1}.")

}
