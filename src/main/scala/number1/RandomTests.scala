//package number1
//
//import java.io.{File, PrintWriter}
//import scala.util.Random
//object RandomTests extends App {
//  val rand = new scala.util.Random
//  val arraySize = 10
//  val writer = new PrintWriter("./src/main/scala/number1/input.txt")
//  writer.write(s"$arraySize\n")
//  for(i <- 0 until arraySize)
//    writer.write(s"${rand.nextInt(4) + 2} ")
//  writer.close()
//}
