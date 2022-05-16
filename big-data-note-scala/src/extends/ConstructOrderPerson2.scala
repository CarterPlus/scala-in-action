package `extends`

/**
 * 这里可能比较疑惑的是为什么 val range = 2 没有被执行，却能使用 range 变量，
 * 这里因为在虚拟机层面，是先对成员变量先分配存储空间并赋给默认值，之后才赋予给定的值。
 * 想要证明这一点其实也比较简单，代码如下:
 */
class ConstructOrderPerson2 {
  // val range: Int = 10 正常代码 array 为 Array(10)
  val array: Array[Int] = new Array[Int](range)
  val range: Int = 10 // lazy 可以解决这个问题
}

object ConstructOrderPerson2 {
  def main(args: Array[String]): Unit = {
    val person = new ConstructOrderPerson2
    println(person.array.length)
  }
}
