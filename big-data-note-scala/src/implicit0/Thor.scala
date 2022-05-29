package implicit0

// 雷神
class Thor(val name: String) {
  // 正常情况下只有雷神才能举起雷神之锤
  def hammer(): Unit = {
    println(name + "举起雷神之锤")
  }
}

object Thor extends App {
  // 定义隐式转换方法 将普通人转换为雷神 通常建议方法名使用 source2Target,即：被转换对象 To 转换对象
  implicit def person2Thor(p: Person): Thor = new Thor(p.name)
  // 这样普通人也能举起雷神之锤
  new Person("普通人").hammer()
}
