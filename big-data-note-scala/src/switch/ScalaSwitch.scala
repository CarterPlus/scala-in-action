package switch

object ScalaSwitch extends App {
  /**
   * 更好的switch
   * Scala 不支持 switch，可以使用模式匹配 match...case 语法代替。但是 match 语句与 Java 中的 switch 有以下三点不同：
   * Scala 中的 case 语句支持任何类型；而 Java 中 case 语句仅支持整型、枚举和字符串常量；
   * Scala 中每个分支语句后面不需要写 break，因为在 case 语句中 break 是隐含的，默认就有；
   * 在 Scala 中 match 语句是有返回值的，而 Java 中 switch 语句是没有返回值的。如下：
   */
  def matchTest(x: Int) = x match {
    case 1 => "one"
    case 2 => "two"
    case _ if x > 9 && x < 100 => "两位数" //支持条件表达式 这被称为模式守卫
    case _ => "other"
  }

  println(matchTest(1)) //输出 one
  println(matchTest(10)) //输出 两位数
  println(matchTest(200)) //输出 other

  /**
   * 用作类型检查
   */
  def matchTypeCheck[T](x: T) = x match {
    case x: Int => "数值型"
    case x: String => "字符型"
    case x: Float => "浮点型"
    case _ => "other"
  }

  println(matchTypeCheck(1)) //输出 数值型
  println(matchTypeCheck(10.3f)) //输出 浮点型
  println(matchTypeCheck("str")) //输出 字符型
  println(matchTypeCheck(2.1)) //输出 other

  /**
   * 匹配数据结构
   */
  def matchTupleStruct(x: Any) = x match {
    case (0, _, _) => "匹配第一个元素为0的元组"
    case (a, b, c) => println(a + "~" + b + "~" + c)
    case _ => "other"
  }

  println(matchTupleStruct((0, 1, 2))) // 输出: 匹配第一个元素为 0 的元组
  matchTupleStruct((1, 2, 3)) // 输出: 1~2~3
  println(matchTupleStruct(Array(10, 11, 12, 14))) // 输出: other

  def matchArrayStruct[T](x: Array[T]) = x match {
    case Array(0) => "匹配只有一个元素 0 的数组"
    case Array(a, b) => println(a + "~" + b)
    case Array(10, _*) => "第一个元素为10的数组"
    case _ => "other"
  }

  println(matchArrayStruct(Array(0))) // 输出: 匹配只有一个元素 0 的数组
  matchArrayStruct(Array(1, 2)) // 输出: 1~2
  println(matchArrayStruct(Array(10, 11, 12))) // 输出: 第一个元素为 10 的数组
  println(matchArrayStruct(Array(3, 2, 1))) // 输出: other

  def matchCaseClass(person: Person) = person match {
    case Student(name, _) => "student:" + name
    case Employee(_, _, salary) => "employee salary:" + salary
    case _ => "other"
  }

  println(matchCaseClass(Student("heibai", 12))) //输出: student:heibai
  println(matchCaseClass(Employee("ying", 22, 999999))) //输出: employee salary:999999.0
}
