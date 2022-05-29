package func

object ScalaCurrying extends App {
  // 我们上面定义的函数都只支持一个参数列表，而柯里化函数则支持多个参数列表。
  // 柯里化指的是将原来接受两个参数的函数变成接受一个参数的函数的过程。
  // 新的函数以原有第二个参数作为参数。
  def curriedSum(x: Int)(y: Int) = x + y

  println(curriedSum(2)(3))

  // 想要获得柯里化的中间返回的函数其实也比较简单：
  // 获取传入值为 10 返回的中间函数 10 + y
  val plus: Int => Int = curriedSum(10)
  println(plus(3)) //输出值 13

  // 柯里化支持多个参数列表，多个参数按照从左到右的顺序依次执行柯里化操作：
  def curriedSum2(x: Int)(y: Int)(z: String) = x + y + z

  println(curriedSum2(2)(3)("name")) // 输出 5name

}
