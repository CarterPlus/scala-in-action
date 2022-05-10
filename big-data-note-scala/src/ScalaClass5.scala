import ScalaClass5.{PREFIX, toLow}

/**
 * 在 Java 中，你通常会用到既有实例方法又有静态方法的类，在 Scala 中，
 * 可以通过类和与类同名的伴生对象来实现。类和伴生对象必须存在与同一个文件中。
 */
class ScalaClass5 {
  private val name = "CARTER"

  def getName: String = toLow(PREFIX + name)
}

// 伴生对象
object ScalaClass5 {
  val PREFIX = "prefix-"

  def toLow(word: String): String = {
    word.toLowerCase
  }

  def main(args: Array[String]): Unit = {
    val person = new ScalaClass5
    // 输出 prefix-carter
    println(person.getName)
  }
}
