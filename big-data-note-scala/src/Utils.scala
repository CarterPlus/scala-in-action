/**
 * 这里我们创建一个对象 Utils,代码如下：
 */
object Utils {
  /*
   *1. 相当于 Java 中的静态代码块 static,会在对象初始化时候被执行
   *   这种方式实现的单例模式是饿汉式单例,即无论你的单例对象是否被用到，
   *   都在一开始被初始化完成
   */
  val person = new Person

  // 2. 全局固定常量 等价于 Java 的 public static final
  val CONSTANT = "固定常量"

  // 3. 全局静态方法
  def low(word: String): String = {
    word.toLowerCase
  }
}
