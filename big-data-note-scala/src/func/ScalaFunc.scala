package func

/** Scala 中函数与方法的区别非常小，如果函数作为某个对象的成员，这样的函数被称为方法，否则就是一个正常的函数。* */
object ScalaFunc extends App {
  // 定义方法
  def multi1(x: Int) = {
    x * x
  }

  // 定义函数
  val multi2 = (x: Int) => {
    x * x
  }

  // 也可以使用 def 定义函数：
  def multi3: Int => Int = (x: Int) => {
    x * x
  }

  /**
   * multi2 和 multi3 本质上没有区别，这是因为函数是一等公民，
   * val multi2 = (x: Int) => {x * x} 这个语句相当于是使用 def 预先定义了函数，之后赋值给变量 multi2。
   */
  /**
   * 上面我们说过 multi2 和 multi3 本质上是一样的，那么作为函数它们是什么类型的？两者的类型实际上都是 Int => Int，
   * 前面一个 Int 代表输入参数类型，后面一个 Int 代表返回值类型。
   */

  println(multi1(3)) // 9
  println(multi2(3)) // 9
  println(multi3(3)) // 9
}
