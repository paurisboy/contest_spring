package number4

import java.io.PrintWriter

object RandomTests extends App {
  val rand = new scala.util.Random
  val n = 10
  val writer = new PrintWriter("./src/main/scala/number4/input.txt")
  writer.write(s"$n L\n")
  for(_ <- 0 until n) {
    for (_ <- 0 until n)
      writer.write(s"${rand.nextLong} ")
    writer.write('\n')
  }
  writer.close()
}
