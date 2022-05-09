// 1.使用类型别名导入枚举类
import ColorEnum.Color

/**
 * 使用枚举类：
 */
object ColorEnumTest extends App {
  // 2.使用枚举类型,这种情况下需要导入枚举类
  def printColor(color: Color): Unit = {
    println(color.toString)
  }

  // 3.判断传入值和枚举值是否相等
  println(ColorEnum.YELLOW.toString == "yellow")
  // 4.遍历枚举类和值
  for (c <- ColorEnum.values) println(c.id + ":" + c.toString)
}
