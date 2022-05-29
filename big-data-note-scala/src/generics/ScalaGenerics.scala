package generics

/**
 * Java 中使用 <> 符号来包含定义的类型参数，Scala 则使用 []。
 */
class ScalaGenerics[T, S](val first: T, val second: S) {
  override def toString: String = first + ":" + second
}

object ScalaGenerics extends App {
  // 使用时候你直接指定参数类型，也可以不指定，由程序自动推断
  val generics01 = new ScalaGenerics("Carter", 22)
  val generics02 = new ScalaGenerics[String, Int]("Carter02", 33)

  println(generics01)
  println(generics02)

  // 函数和方法也支持类型参数。
  def getHalf[T](a: Array[T]): Int = a.length / 2
}
