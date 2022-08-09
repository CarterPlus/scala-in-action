package scala

class ScalaNormalClass {
  var id: Int = _

  var name: String = _

  var remark: String = _

  override def toString: String = "ScalaNormalClass{id = " + id + ", name = " + name + ", remark = " + remark + "}"

}

object ScalaNormalClass {
  def main(args: Array[String]): Unit = {
    val normalClass = new ScalaNormalClass

    normalClass.id = 1
    normalClass.name = "Carter"
    normalClass.remark = "幸运"

    println(normalClass) // ScalaNormalClass{id = 1, name = Carter, remark = 幸运}
  }
}