package `trait`

/**
 * 和方法一样，特质中的字段可以是抽象的，也可以是具体的：
 *
 * 如果是抽象字段，则混入特质的类需要重写覆盖该字段；
 * 如果是具体字段，则混入特质的类获得该字段，但是并非是通过继承关系得到，而是在编译时候，简单将该字段加入到子类。
 */
trait TraitLogger {
  // 抽象字段
  var LogLevel: String
  // 具体字段
  var LogType = "FIFE"
}
