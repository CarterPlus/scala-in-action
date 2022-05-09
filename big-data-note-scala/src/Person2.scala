import scala.beans.BeanProperty

class Person2 {
  @BeanProperty var name = "Carter Lin"
  private var age = 12
  private[this] val birthday = "2022-09-12"
  // birthday 只能被内部方法所访问
  def getBirthday: String = birthday
}

object Person2 {
  def main(args: Array[String]): Unit = {
    val person = new Person2
    person.age = 30
    println(person.name)
    person.setName("Cherry Zhang")
    println(person.getName)
    println(person.age)
    println(person.getBirthday)
  }
}