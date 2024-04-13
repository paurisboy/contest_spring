package number2

import java.util.Scanner

object Main {
  val in = new Scanner(System.in)

  def solution(matrix: Array[Array[Long]], n: Int, m: Int): Array[Array[Long]] = {
    val rotated_matrix = Array.ofDim[Long](m, n)
    for(i <- 0 until m)
      for(j <- 0 until n)
        rotated_matrix(i)(j) = matrix(n-j-1)(i)
    rotated_matrix
  }

  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val m = in.nextInt()
    val array = Array.ofDim[Long](n, m)
    for(i <- 0 until n) {
      for(j <-0 until m)
       array(i)(j) = in.nextLong()
    }
    val rotated = solution(array, n, m)
    for {
      row <- rotated
      _ = println(row.mkString(" "))
    } yield ()
  }
}
