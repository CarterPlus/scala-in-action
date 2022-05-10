// 1.UtilsTest 对象扩展自 trait App
object ScalaUtilsTest extends App {
  // 2.验证单例
  println(ScalaUtils.person == ScalaUtils.person)

  // 3.获取全局常量
  println(ScalaUtils.CONSTANT)

  // 4.调用工具类
  println(ScalaUtils.low("ABCDEFG"))
}
