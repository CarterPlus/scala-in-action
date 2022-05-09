import scala.collection.{SortedSet, immutable, mutable}

object ScalaCollection {

  def main(args: Array[String]): Unit = {
    // Scala 中的大部分集合类都存在三类变体，分别位于 scala.collection, scala.collection.immutable, scala.collection.mutable 包中。
    // 还有部分集合类位于 scala.collection.generic 包下。
    val sortSet: SortedSet[Int] = scala.collection.SortedSet(1, 2, 3, 4, 5)
    val mutableSortSet: mutable.SortedSet[Int] = collection.mutable.SortedSet(1, 2, 3, 4, 5)
    val immutableSortSet: immutable.SortedSet[Int] = collection.immutable.SortedSet(1, 2, 3, 4, 5)
    // 如果你仅写了 Set 而没有加任何前缀也没有进行任何 import，则 Scala 默认采用不可变集合类。
    println(sortSet)
    println(mutableSortSet)
    println(immutableSortSet)
  }
}
