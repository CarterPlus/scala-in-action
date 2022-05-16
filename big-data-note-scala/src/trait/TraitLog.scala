package `trait`

/**
 * Scala 中没有 interface 这个关键字，想要实现类似的功能，可以使用特质 (trait)。
 * trait 等价于 Java 8 中的接口，因为 trait 中既能定义抽象方法，也能定义具体方法，这和 Java 8 中的接口是类似的。
 */
// 1.特质使用 trait 关键字修饰
trait TraitLog {
  // 2.定义抽象方法
  def log(msg: String)

  // 3.定义具体方法
  def logInfo(msg: String): Unit = {
    println("INFO:" + msg)
  }
}
