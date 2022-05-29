package implicit0

// 隐式参数
// 定义分隔符类
class Delimiters(val left: String, val right: String)

object ImplicitParam extends App {
  // 进行格式化输出
  def formatted(context: String)(implicit deli: Delimiters): Unit = {
    println(deli.left + context + deli.right)
  }

  // 定义一个隐式默认值，使用左右中括号作为分隔符
  implicit val bracket = new Delimiters("(", ")")
  formatted("this is context") // 输出: (this is context)
}
