package number2

import java.io.{File, PrintWriter}
import scala.util.Random
object RandomTests extends App {
  val rand = new scala.util.Random
  val n = 1000
  val m = 1000
  val writer = new PrintWriter("./src/main/scala/number2/input.txt")
  writer.write(s"$n $m\n")
  for(_ <- 0 until n) {
    for (_ <- 0 until n)
      writer.write(s"${rand.nextLong} ")
    writer.write('\n')
  }
  writer.close()
}
