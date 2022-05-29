package func

// 高阶函数
object HigherOrderFunc extends App {
  // 1. 定义函数
  def square: Int => Int = (x: Int) => {
    x * x
  }

  // 2.定义高阶函数: 第一个参数是类型为 Int => Int 的函数
  def multi(fun: Int => Int, x: Int) = {
    fun(x) * 100
  }

  // 3.传入具名函数
  println(multi(square, 5)) // 输出 2500

  // 4.传入匿名函数
  println(multi(_ * 100, 5)) // 输出 50000

}
