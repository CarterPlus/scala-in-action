package `extends`

/**
 * 想要解决上面的问题，有以下几种方法：
 * (1) . 将变量用 final 修饰，代表不允许被子类重写，即 final val range: Int = 10 ；
 * (2) . 将变量使用 lazy 修饰，代表懒加载，即只有当你实际使用到 array 时候，才去进行初始化；
 * // lazy val array: Array[Int] = new Array[Int](range)
 * (3) . 采用提前定义，代码如下，代表 range 的定义优先于超类构造器。
 */
class DefinedInAdvance extends {
  //这里不能定义其他方法
  override val range = 2
} with ConstructOrderPerson {
  // 定义其他变量或者方法
  def pr(): Unit = {
    println("Employee")
  }
  // 但是这种语法也有其限制：你只能在上面代码块中重写已有的变量，而不能定义新的变量和方法，定义新的变量和方法只能写在下面代码块中。
}
