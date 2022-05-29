package implicit0

class ClassA {
  override def toString: String = "This is Class A"
}

class ClassB {
  override def toString: String = "This is Class B"

  def printB(b: ClassB): Unit = println(b)
}

class ClassC

class ClassD

object ImplicitTest extends App {
  implicit def A2B(a: ClassA): ClassB = {
    println("A2B")
    new ClassB
  }

  implicit def C2B(c: ClassC): ClassB = {
    println("C2B")
    new ClassB
  }

  implicit def D2C(d: ClassD): ClassC = {
    println("D2C")
    new ClassC
  }

  // 这行代码无法通过编译，因为要调用到 printB 方法，需要执行两次转换 C2B(D2C(ClassD))
  //  new ClassD().printB(new ClassA)

  /*
   *  下面的这一行代码虽然也进行了两次隐式转换，但是两次的转换对象并不是一个对象,所以它是生效的:
   *  转换流程如下:
   *  1. ClassC 中并没有 printB 方法,因此隐式转换为 ClassB,然后调用 printB 方法;
   *  2. 但是 printB 参数类型为 ClassB,然而传入的参数类型是 ClassA,所以需要将参数 ClassA 转换为 ClassB,这是第二次;
   *  即: C2B(ClassC) -> ClassB.printB(ClassA) -> ClassB.printB(A2B(ClassA)) -> ClassB.printB(ClassB)
   *  转换过程 1 的对象是 ClassC,而转换过程 2 的转换对象是 ClassA,所以虽然是一行代码两次转换，但是仍然是有效转换
   */
  new ClassC().printB(new ClassA)
}
