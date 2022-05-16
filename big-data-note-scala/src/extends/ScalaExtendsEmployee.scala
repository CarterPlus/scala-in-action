package `extends`

// 1.使用 extends 关键字实现继承
class ScalaExtendsEmployee extends ScalaExtendsPerson {
  override def toString: String = "Employee~" + super.toString

  // 2.使用 public 或 protected 关键字修饰的变量能被子类访问
  def setBirthday(date: String): Unit = {
    birthday = date
  }
}
