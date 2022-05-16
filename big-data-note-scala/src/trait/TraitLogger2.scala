package `trait`

/**
 * Scala 支持在类定义的时混入 父类 trait，而在类实例化为具体对象的时候指明其实际使用的 子类 trait。示例如下：
 */
// 父类
trait TraitLogger2 {
  // 定义空方法，日志打印
  def log(msg: String) {}
}

// 错误日志打印，继承自 Logger
trait TraitErrorLogger extends TraitLogger2 {
  // 覆盖空方法
  override def log(msg: String): Unit = {
    println("Error: " + msg)
  }
}

// 通知日志打印，继承自 Logger
trait TraitInfoLogger extends TraitLogger2 {
  // 覆盖空方法
  override def log(msg: String): Unit = {
    println("Info: " + msg)
  }
}

// 具体的使用类：
class TraitPerson extends TraitLogger2 {
  // 调用定义的抽象方法
  def printDetail(detail: String): Unit = {
    log(detail)
  }
}