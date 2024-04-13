val array = Array[String](
  "root/a",
    "root/a/b",
    "root/c/x",
    "root/a/b/c",
    "root",
    "root/c"
)
import scala.collection.mutable

// Определяем узел дерева для директории
case class DirectoryNode(name: String) {
  val children: mutable.Map[String, DirectoryNode] = mutable.Map[String, DirectoryNode]()

  // Добавляем дочернюю директорию
  def addChild(child: DirectoryNode): Unit = {
    children += (child.name -> child)
  }

  // Выводим дерево начиная с текущего узла с заданным отступом
  def printTree(indent: Int = 0): Unit = {
    println(" " * indent + name)
    children.values.toList.sortBy(_.name).foreach(_.printTree(indent + 2))
  }
}

    val n = 6

    // Создаем корневой узел
    val root = DirectoryNode("root")

    // Строим дерево на основе введенных данных
    for (j <- 0 until n) {
      val path = array(j).split("/")
      var current = root
      for (i <- 1 until path.length) {
        if (!current.children.contains(path(i))) {
          val newNode = DirectoryNode(path(i))
          current.addChild(newNode)
          current = newNode
        } else {
          current = current.children(path(i))
        }
      }
    }

    // Выводим дерево начиная с корня
    root.printTree()