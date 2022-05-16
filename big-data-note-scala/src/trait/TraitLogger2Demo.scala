package `trait`

object TraitLogger2Demo extends App {
  // 使用 with 指明需要具体使用的 trait
  val person01 = new TraitPerson with TraitInfoLogger
  val person02 = new TraitPerson with TraitErrorLogger
  val person03 = new TraitPerson with TraitInfoLogger with TraitErrorLogger
  person01.log("scala")  //输出 INFO:scala
  person02.log("scala")  //输出 Error:scala
  person03.log("scala")  //输出 Error:scala
}
