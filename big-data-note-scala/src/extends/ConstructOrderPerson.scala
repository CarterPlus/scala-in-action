package `extends`

/**
 * 构造顺序
 * 在 Scala 中还有一个需要注意的问题，如果你在子类中重写父类的 val 变量，
 * 并且超类的构造器中使用了该变量，那么可能会产生不可预期的错误。下面给出一个示例：
 * */
// 父类
class ConstructOrderPerson {
  println("父类的默认构造器")
  val range: Int = 10
  val array: Array[Int] = new Array[Int](range)
}

// 子类
class ConstructOrderEmployee extends ConstructOrderPerson {
  println("子类的默认构造器")
  override val range = 2
}

// 测试
object ConstructOrderPerson extends App {
  val employee = new ConstructOrderEmployee
  println(employee.array.mkString("(", ",", ")"))
  // 这里初始化 array 用到了变量 range，这里你会发现实际上 array 既不会被初始化 Array(10)，也不会被初始化为 Array(2)，实际的输出应该如下：
  // 父类的默认构造器
  // 子类的默认构造器
  // ()
  /**
   * 可以看到 array 被初始化为 Array(0)，主要原因在于父类构造器的执行顺序先于子类构造器，这里给出实际的执行步骤：
   *
   * 父类的构造器被调用，执行 new Array[Int](range) 语句;
   * 这里想要得到 range 的值，会去调用子类 range() 方法，因为 override val 重写变量的同时也重写了其 get 方法；
   * 调用子类的 range() 方法，自然也是返回子类的 range 值，但是由于子类的构造器还没有执行，这也就意味着对 range 赋值的 range = 2 语句还没有被执行，所以自然返回 range 的默认值，也就是 0。
   */
}

