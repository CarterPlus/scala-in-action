package `extends`

/**
 * extends & override
 * Scala 的集成机制和 Java 有很多相似之处，比如都使用 extends 关键字表示继承，都使用 override 关键字表示重写父类的方法或成员变量。示例如下：
 */
// 父类
class ScalaExtendsPerson {
  var name = ""
  // 1.不加任何修饰词,默认为 public,能被子类和外部访问
  var age = 0
  // 2.使用 protected 修饰的变量能子类访问，但是不能被外部访问
  protected var birthday = ""
  // 3.使用 private 修饰的变量不能被子类和外部访问
  private var sex = ""

  def setSex(sex: String): Unit = {
    this.sex = sex
  }

  // 4.重写父类的方法建议使用 override 关键字修饰
  override def toString: String = name + ":" + age + ":" + birthday + ":" + sex

}
