package generics

/** 类型限定 * */
// 使用 <: 符号，限定 T 必须是 Comparable[T]的子类型
class TypesOfQualified[T <: Comparable[T]](val first: T, val second: T) {
  // 返回较小的值
  def smaller: T = if (first.compareTo(second) < 0) first else second
}

// 测试代码
object TypesOfQualified extends App {
  val typesOfQualified = new TypesOfQualified("abc", "abcd")
  println(typesOfQualified.smaller)
}
