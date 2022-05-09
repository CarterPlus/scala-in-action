/**
 * 辅助构造器
 * 辅助构造器有两点硬性要求：
 * 辅助构造器的名称必须为 this；
 * 每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始。
 */
class Person4(val name: String, val age: Int) {
  private var birthday = ""

  // 1.辅助构造器的名称必须为 this
  def this(name: String, age: Int, birthday: String) {
    // 2.每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
    this(name, age)
    this.birthday = birthday
  }

  // 3.重写 toString 方法
  override def toString: String = name + ":" + age + ":" + birthday
}

object Person4 {
  def main(args: Array[String]): Unit = {
    println(new Person4("Carter Hong", 10, "2022-02-02"))
  }
}
