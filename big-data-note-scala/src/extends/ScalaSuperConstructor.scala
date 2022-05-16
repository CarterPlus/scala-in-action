package `extends`

/**
 * 调用超类构造器
 * 在 Scala 的类中，每个辅助构造器都必须首先调用其他构造器或主构造器，
 * 这样就导致了子类的辅助构造器永远无法直接调用超类的构造器，只有主构造器才能调用超类的构造器。
 * 所以想要调用超类的构造器，代码示例如下：
 */
class ScalaSuperConstructor(name: String, age: Int, birthday: String) extends ScalaSuperClass(name: String, age: Int) {

}
