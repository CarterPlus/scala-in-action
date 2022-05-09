object ScalaTuple {
  def main(args: Array[String]): Unit = {
    // 元组与数组类似，但是数组中所有的元素必须是同一种类型，而元组则可以包含不同类型的元素。
    val tuple1 = (1, 3.24f, "scala")
    println(tuple1)

    // 可以通过模式匹配来获取元组中的值并赋予对应的变量
    val (a, b, c) = tuple1
    println(a, b, c)
    // 如果某些位置不需要赋值，则可以使用下划线代替：
    val (e, _, _) = tuple1
    println(e)

    // zip方法
    val array01 = Array("hadoop", "spark", "storm")
    val array02 = Array(10, 20, 30)
    // 1.zip 方法得到的是多个 tuple 组成的数组
    val tuples: Array[(String, Int)] = array01.zip(array02)
    println(tuples.mkString(", "))
    // 2.也可以在 zip 后调用 toMap 方法转换为 Map
    val toMap = array01.zip(array02).toMap
    println(toMap)
  }
}
