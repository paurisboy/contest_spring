package number3
import java.util.Scanner
object Main {
  val in = new Scanner(System.in)

  case class Node(heirs: List[Node], name: String) {
    def createRoot(root: String): Node = {
      ???
    }
  }


  def solution(array: Array[String], length: Int): Array[String] = {
    val splited = array.map(_.split('/').zipWithIndex)
    ???
  }

  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val array = new Array[String](n)
    for(i <- 0 until n)
      array(i) = in.nextLine()


  }
}
