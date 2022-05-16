package `extends`

object ScalaTypeCheckAndConvert extends App {
  val employee = new ScalaExtendsEmployee
  val person = new ScalaExtendsPerson

  // 1. 判断一个实例是否来源于某个类或者其子类 输出 true
  println(employee.isInstanceOf[ScalaExtendsPerson])
  println(person.isInstanceOf[ScalaExtendsPerson])

  // 2. 强制类型转换
  private val scalaExtendsPerson: ScalaExtendsPerson = employee.asInstanceOf[ScalaExtendsPerson]

  // 3. 判断一个实例是否来源于某个类 (而不是其子类)
  println(employee.getClass == classOf[ScalaExtendsEmployee])
}
