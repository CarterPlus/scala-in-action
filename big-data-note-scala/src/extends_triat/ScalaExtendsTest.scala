package extends_triat

object ScalaExtendsTest extends App {
  val employee = new ScalaExtendsEmployee

  employee.name = "Carter"
  employee.age = 20
  employee.setBirthday("2022-02-02")
  employee.setSex("Man")

  println(employee) // Employee~Carter:20:2022-02-02:Man
}
