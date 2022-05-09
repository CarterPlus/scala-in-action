
import java.util
import scala.collection.mutable.ArrayBuffer
import scala.collection.{JavaConverters, mutable}

object ScalaArrayBuffer {
  def main(args: Array[String]): Unit = {
    /*变长数组*/
    // 1.声明变长数组 (缓冲数组)
    val ab = new ArrayBuffer[Int]()
    // 2.在末端增加元素
    ab += 1
    // 3.在末端添加多个元素
    ab += (2, 3, 4)
    // 4.可以使用 ++=追加任何集合
    ab ++= Array(5, 6, 7)
    // 5.缓冲数组可以直接打印查看
    println(ab)
    // 6.移除最后三个元素
    ab.trimEnd(3)
    // 7.在第 1 个元素之后插入多个新元素
    ab.insert(1, 8)
    // 8.从第 2 个元素开始,移除 3 个元素,不指定第二个参数的话,默认值为 1
    ab.remove(2, 3)
    // 9.缓冲数组转定长数组
    val abToA = ab.toArray
    // 10. 定长数组打印为其 hashcode 值
    println(abToA.hashCode())
    //    println(abToA.mkString("Array(", ", ", ")"))
    // 11. 定长数组转缓冲数组
    val aToAb = abToA.toBuffer

    /*数组遍历*/
    val a = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // 1.方式一 相当于 Java 中的增强 for 循环
    for (elem <- a) {
      print(elem)
    }

    // 2.方式二
    for (index <- 0 until a.length) {
      print(a(index))
    }
    println()

    // 3.方式三, 是第二种方式的简写
    for (index <- a.indices) {
      print(a(index))
    }
    println()

    // 4.反向遍历
    for (index <- a.indices.reverse) {
      print(a(index))
    }
    println()

    // 数组转换是指由现有数组产生新的数组。假设当前拥有 a 数组，想把 a 中的偶数元素乘以 10 后产生一个新的数组，可以采用下面两种方式来实现：
    val b = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // 1.方式一 yield 关键字
    val ints1: Array[Int] = for (elem <- b if elem % 2 == 0) yield 10 * elem
    println(ints1.mkString("Array(", ", ", ")"))
    // 2.方式二 采用函数式编程的方式,这和 Java 8 中的函数式编程是类似的，这里采用下划线标表示其中的每个元素
    val ints2: Array[Int] = b.filter(_ % 2 == 0).map(_ * 10)
    println(ints2.mkString("Array(", ", ", ")"))

    // 和 Java 中一样，多维数组由单维数组组成。
    val matrix = Array(
      Array(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      Array(21, 22, 23, 24, 25, 26, 27, 28, 29, 30),
      Array(31, 32, 33, 34, 35, 36, 37, 38, 39, 40)
    )
    for (elem <- matrix) {
      for (elem <- elem) {
        print(elem + "-")
      }
      println()
    }

    // 由于 Scala 的数组是使用 Java 的数组来实现的，所以两者之间可以相互转换。
    val element = ArrayBuffer("hadoop", "spark", "storm")
    // Scala 转 Java
    val javaList: util.List[String] = JavaConverters.bufferAsJavaListConverter(element).asJava
    // Java 转 Scala
    val scalaBuffer: mutable.Buffer[String] = JavaConverters.asScalaBufferConverter(javaList).asScala
    println(javaList)
    println(scalaBuffer)
  }
}
