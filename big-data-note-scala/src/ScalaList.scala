import scala.collection.mutable.ListBuffer

object ScalaList {
  def main(args: Array[String]): Unit = {
    val list = List("hadoop", "spark", "storm")
    // 1.列表是否为空
    println(list.isEmpty)
    // 2.返回列表中的第一个元素
    println(list.head)
    // 3.返回列表中除第一个元素外的所有元素 这里输出 List(spark, storm)
    println(list.tail)
    // 4.tail 和 head 可以结合使用
    println(list.tail.head)
    // 5.返回列表中除了最后一个元素之外的其他元素；与 tail 相反 这里输出 List(hadoop, spark)
    println(list.init)
    // 6.返回列表中的最后一个元素 与 head 相反
    println(list.last)
    // 7.使用下标访问元素
    list(2)
    // 8.获取列表长度
    println(list.size)
    // 9. 反转列表
    println(list.reverse)

    // indices 方法返回所有下标。
    println(list.indices)

    /**
     * take：获取前 n 个元素；
     * drop：删除前 n 个元素；
     * splitAt：从第几个位置开始拆分。
     */
    println(list.take(2))
    println(list.drop(1))
    println(list splitAt 1)

    // flatten 接收一个由列表组成的列表，并将其进行扁平化操作，返回单个列表。
    println(List(List(1, 2), List(3), List(), List(4, 5)))

    // 对两个 List 执行 zip 操作结果如下，返回对应位置元素组成的元组的列表，unzip 则执行反向操作。
    val score = List(10, 20, 30)
    val zipped = list.zip(score)
    println(zipped)
    val (unzipString, unzipInt) = zipped.unzip
    println(unzipString)
    println(unzipInt)

    // toString 返回 List 的字符串表现形式。
    println(list.toString())

    // 如果想改变 List 的字符串表现形式，可以使用 mkString。mkString 有三个重载方法，方法定义如下：
    println(list.mkString)
    println(list.mkString(","))
    println(list.mkString("{", ",", "}"))

    // iterator 方法返回的是迭代器，这和其他语言的使用是一样的。
    val iterator: Iterator[String] = list.iterator
    while (iterator.hasNext) {
      print(iterator.next() + " - ")
    }
    println()

    // toArray 和 toList 用于 List 和数组之间的互相转换。
    val array = list.toArray
    println(array.mkString("Array(", ", ", ")"))
    val listCopy = array.toList
    println(listCopy)

    // copyToArray 将 List 中的元素拷贝到数组中指定位置。
    val tmpArray = Array("10", "20", "30")

    // map 与 Java 8 函数式编程中的 map 类似，都是对 List 中每一个元素执行指定操作
    println(List(1, 2, 3).map(_ + 10))
    // flatMap 与 map 类似，但如果 List 中的元素还是 List，则会对其进行 flatten 操作。
    println(list.map(_.toList))
    println(list.flatMap(_.toList))

    // foreach 要求右侧的操作是一个返回值为 Unit 的函数，你也可以简单理解为执行一段没有返回值代码。
    var sum = 0
    List(1, 2, 3, 4, 5).foreach(sum += _)
    println(sum)

    // filter 用于筛选满足条件元素，返回新的 List。
    println(List(1, 2, 3, 4, 5).filter(_ % 2 == 0))

    // partition 会按照筛选条件对元素进行分组，返回类型是 tuple(元组)。
    println(List(1, 2, 3, 4, 5).partition(_ % 2 == 0))

    // find 查找第一个满足条件的值，由于可能并不存在这样的值，所以返回类型是 Option，可以通过 getOrElse 在不存在满足条件值的情况下返回默认值。
    val maybeInt = List(1, 2, 3, 4, 5).find(_ % 2 == 0)
    println(maybeInt)
    println(maybeInt.getOrElse(0))

    // takeWhile 遍历元素，直到遇到第一个不符合条件的值则结束遍历，返回所有遍历到的值。
    println(List(1, 2, 3, -4, 5).takeWhile(_ > 0))
    // dropWhile 遍历元素，直到遇到第一个不符合条件的值则结束遍历，返回所有未遍历到的值。
    println(List(1, 2, 3, -4, 5).dropWhile(_ < 3))
    // span 遍历元素，直到遇到第一个不符合条件的值则结束遍历，将遍历到的值和未遍历到的值分别放入两个 List 中返回，返回类型是 tuple(元组)。
    println(List(1, 2, 3, -4, 5).span(_ < 3))

    // forall 检查 List 中所有元素，如果所有元素都满足条件，则返回 true。
    println(List(1, 2, 3, -4, 5).forall(_ > 0))
    // exists 检查 List 中的元素，如果某个元素已经满足条件，则返回 true。
    println(List(1, 2, 3, -4, 5).exists(_ > 0))

    // sortWith 对 List 中所有元素按照指定规则进行排序，由于 List 是不可变的，所以排序返回一个新的 List。
    println(List(1, -3, 4, 2, 6).sortWith(_ < _))
    println(List("hive", "spark", "azkaban", "hadoop").sortWith(_.length > _.length))

    // List.range 可以产生指定的前闭后开区间内的值组成的 List，它有三个可选参数: start(开始值)，end(结束值，不包含)，step(步长)。
    println(List.range(1, 5))
    println(List.range(1, 9, 2))
    println(List.range(9, 1, -3))

    // List.fill 使用指定值填充 List。
    println(List.fill(3)("hello"))
    println(List.fill(2, 3)("world"))

    // List.concat 用于拼接多个 List。
    println(List.concat(List('a', 'b'), List('c')))
    println(List.concat(List(), List('b'), List('c')))
    println(List.concat())

    // 当多个 List 被放入同一个 tuple 中时候，可以通过 zipped 对多个 List 进行关联处理。
    // 两个 List 对应位置的元素相乘
    println((List(10, 20), List(3, 4, 5)).zipped.map(_ * _))
    // 三个 List 的操作也是一样的
    println((List(10, 20), List(3, 4, 5), List(100, 200)).zipped.map(_ * _ + _))
    // 判断第一个 List 中元素的长度与第二个 List 中元素的值是否相等
    println((List("abc", "de"), List(3, 2)).zipped.forall(_.length == _))

    // 上面介绍的 List，由于其底层实现是链表，这意味着能快速访问 List 头部元素，但对尾部元素的访问则比较低效，
    // 这时候可以采用 ListBuffer，ListBuffer 提供了在常量时间内往头部和尾部追加元素。
    val buffer = new ListBuffer[Int]
    // 1.在尾部追加元素
    buffer += 1
    buffer += 2
    // 2.在头部追加元素
    3 +=: buffer
    // 3. ListBuffer 转 List
    val list1: List[Int] = buffer.toList
    println(list1)
  }
}
