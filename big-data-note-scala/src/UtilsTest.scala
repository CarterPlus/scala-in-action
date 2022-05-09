// 1.UtilsTest 对象扩展自 trait App
object UtilsTest extends App {
  // 2.验证单例
  println(Utils.person == Utils.person)

  // 3.获取全局常量
  println(Utils.CONSTANT)

  // 4.调用工具类
  println(Utils.low("ABCDEFG"))
}
