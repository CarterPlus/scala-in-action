import java.time.LocalDateTime

// case class的格式化有点怪怪，不是那么美观
case class CaseClassDemo(
                          id: Int,
                          name: String,
                          birthday: LocalDateTime,
                          address: String
                        )

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    // case class 的 toString方法是可以显示出每个参数的具体数值
    val caseClassDemo = new CaseClassDemo(id = 12, name = "Marry", birthday = LocalDateTime.now(), address = "Guangzhou Guangdong")
    println(caseClassDemo.toString) // CaseClassDemo(12,Marry,2022-05-05T22:24:44.340328900,Guangzhou Guangdong)
  }
}
