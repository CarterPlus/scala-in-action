import scala.collection.immutable.HashSet
import scala.collection.mutable

object ScalaSet {
  def main(args: Array[String]): Unit = {
    // Set 是不重复元素的集合。分为可变 Set 和不可变 Set。

    // 可变 Set
    val mutableSet = new mutable.HashSet[Int]()
    // 1.添加元素
    mutableSet.add(1)
    mutableSet.add(2)
    mutableSet.add(3)
    mutableSet.add(3)
    mutableSet.add(4)
    println(mutableSet)
    // 2.移除元素
    mutableSet.remove(2)
    println(mutableSet)
    // 3.调用 mkString 方法 输出 1,3,4
    println(mutableSet.mkString(", "))
    // 4. 获取 Set 中最小元素
    println(mutableSet.min)
    // 5. 获取 Set 中最大元素
    println(mutableSet.max)

    // 不可变 Set 没有 add 方法，可以使用 + 添加元素，但是此时会返回一个新的不可变 Set，原来的 Set 不变。
    val immutableSet = new collection.immutable.HashSet[Int]
    val ints: HashSet[Int] = immutableSet + 1
    println(immutableSet)
    println(ints)

    // 多个 Set 之间可以进行求交集或者合集等操作。
    // 声明有序 Set
    val mutableSet0 = collection.mutable.SortedSet(1, 2, 3, 4, 5)
    val immutableSet0 = collection.immutable.SortedSet(3, 4, 5, 6, 7)
    // 两个 Set 的合集  输出：TreeSet(1, 2, 3, 4, 5, 6, 7)
    println(mutableSet0 ++ immutableSet0)
    // 两个 Set 的交集  输出：TreeSet(3, 4, 5)
    println(mutableSet.intersect(immutableSet0))


  }
}
