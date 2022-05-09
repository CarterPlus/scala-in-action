import java.util
import scala.collection.JavaConverters
import scala.collection.immutable.HashMap

object ScalaMap {

  def main(args: Array[String]): Unit = {
    /*构造Map*/
    // 初始化一个空 map
    val score01 = new HashMap[String, Int]()
    println(score01)
    // 从指定的值初始化 Map（方式一）
    val score02 = Map("hadoop" -> 10, "spark" -> 20, "storm" -> 30)
    println(score02)
    // 从指定的值初始化 Map（方式二）
    val score03 = Map(("hadoop", 10), ("spark", 20), ("storm", 30))
    println(score03)

    /*获取值*/
    val mutableScores = scala.collection.mutable.Map("hadoop" -> 10, "spark" -> 20, "storm" -> 30)
    // 1.获取指定 key 对应的值
    println(mutableScores("hadoop"))
    // 2. 如果对应的值不存在则使用默认值
    println(mutableScores.getOrElse("hive", 40))

    /*新增/修改/删除值*/
    // 1.如果 key 存在则更新
    mutableScores("hadoop") = 100
    // 2.如果 key 不存在则新增
    mutableScores("flink") = 40
    // 3.可以通过 += 来进行多个更新或新增操作
    mutableScores += ("spark" -> 200, "hive" -> 50)
    // 4.可以通过 -= 来移除某个键和值
    mutableScores -= "storm"
    // 遍历map
    for (elem <- mutableScores) print(elem + " ")
    println()

    // 不可变 Map 不允许进行新增、修改、删除等操作，但是允许由不可变 Map 产生新的 Map。
    val immutableScores = scala.collection.immutable.Map("hadoop" -> 10, "spark" -> 20, "storm" -> 30)
    val newImmutableScores = immutableScores + ("spark" -> 200, "hive" -> 50)
    for (elem <- newImmutableScores) print(elem + " ")
    println()

    /*遍历Map*/
    // 1. 遍历键
    for (key <- mutableScores.keys) print(key + " ")
    println()
    // 2. 遍历值
    for (value <- mutableScores.values) print(value + " ")
    println()
    // 3. 遍历键值对
    for ((key, value) <- mutableScores) print("(" + key + "," + value + ") ")
    println()

    /*yield关键字*/
    // 可以使用 yield 关键字从现有 Map 产生新的 Map。
    // 1.将 scores 中所有的值扩大 10 倍
    val newScores2 = for ((key, value) <- immutableScores) yield (key, value * 10)
    println(newScores2)
    // 2.将键和值互相调换
    val reversalScore: Map[Int, String] = for ((key, value) <- immutableScores) yield (value, key)
    println(reversalScore)

    /*其他Map结构*/
    // 在使用 Map 时候，如果不指定，默认使用的是 HashMap，如果想要使用 TreeMap 或者 LinkedHashMap，则需要显式的指定。
    // 1.使用 TreeMap,按照键的字典序进行排序
    val scores01 = scala.collection.immutable.TreeMap("B" -> 20, "A" -> 10, "C" -> 30)
    println(scores01)
    // 2.使用 LinkedHashMap,按照键值对的插入顺序进行排序
    val scores02 = scala.collection.mutable.LinkedHashMap("B" -> 20, "A" -> 10, "C" -> 30)
    println(scores02)

    /*可选方法*/
    // 1. 获取长度
    println(immutableScores.size)
    // 2. 判断是否为空
    println(immutableScores.isEmpty)
    // 3. 判断是否包含特定的 key
    println(immutableScores.contains("A"))

    /*与Java互操作*/
    // scala map 转 java map
    val asJava: util.Map[String, Int] = JavaConverters.mapAsJavaMapConverter(immutableScores).asJava
    println(asJava)
    // java map 转 scala map
    val asScala = JavaConverters.mapAsScalaMapConverter(asJava).asScala
    println(asScala)

  }
}
