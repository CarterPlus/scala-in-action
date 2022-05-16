package `abstract`

/**
 * Scala 中允许使用 abstract 定义抽象类，并且通过 extends 关键字继承它。
 * 定义抽象类：
 */
abstract class AbstractPerson {
  // 1. 定义字段
  var name: String
  val age: Int

  // 2. 定义抽象方法
  def getDetail: String

  // 3. Scala的抽象类允许定义具体方法
  def print(): Unit = {
    println("抽象类中的默认方法")
  }
}

// 继承抽象类：
class AbstractEmployee extends AbstractPerson {
  // 覆盖抽象类中变量
  override var name: String = "Carter"
  override val age: Int = 12

  // 覆盖抽象方法
  override def getDetail: String = name + ":" + age
}
