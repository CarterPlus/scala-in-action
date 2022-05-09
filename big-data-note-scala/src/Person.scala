// 1. 在 scala 中，类不需要用 public 声明,所有的类都具有公共的可见性
class Person {

  println("Person 默认构造器被调用")

  // 2. 声明私有变量,用 var 修饰的变量默认拥有 getter/setter 属性
  private var age = 0

  // 3.如果声明的变量不需要进行初始赋值，此时 Scala 就无法进行类型推断，所以需要显式指明类型
  private var name: String = _

  // 4. 定义方法,应指明传参类型。返回值类型不是必须的，Scala 可以自动推断出来，但是为了方便调用者，建议指明
  def growUp(step: Int): Unit = {
    age += step
  }

  // 5.对于改值器方法 (即改变对象状态的方法),即使不需要传入参数,也建议在声明中包含 ()
  def growUpFix(): Unit = {
    age += 10
  }

  // 6.对于取值器方法 (即不会改变对象状态的方法),不必在声明中包含 ()
  def getName: String = name
}

// 伴生对象
object Person {
  def main(args: Array[String]): Unit = {
    // 8.创建类的实例
    val person = new Person()
    // 9.用 var 修饰的变量默认拥有 getter/setter 属性，可以直接对其进行赋值
    person.age = 12
    person.growUp(8)
    person.growUpFix()
    // 10.用 var 修饰的变量默认拥有 getter/setter 属性，可以直接对其进行取值，输出: 30
    println(person.age)
    // 输出: null
    println(person.getName)
  }
}
