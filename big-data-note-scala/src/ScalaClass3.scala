class ScalaClass3(val name: String, val age: Int) {
  println("功能类似于 Java 的静态代码块 static{}")

  def getDetail: String = {
    name + ":" + age
  }
}

object ScalaClass3 {
  def main(args: Array[String]): Unit = {
    val person = new ScalaClass3("Carter Zhang", 18)
    println(person.getDetail)
  }
}
