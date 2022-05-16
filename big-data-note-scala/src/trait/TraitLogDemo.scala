package `trait`

/**
 * 想要使用特质，需要使用 extends 关键字，而不是 implements 关键字，如果想要添加多个特质，可以使用 with 关键字。
 */
// 1.使用 extends 关键字,而不是 implements,如果想要添加多个特质，可以使用 with 关键字
class TraitLogDemo extends TraitLog with Cloneable {
  override def log(msg: String): Unit = {
    println("CONSOLE: " + msg)
  }
}
