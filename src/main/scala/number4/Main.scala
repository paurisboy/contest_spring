package number4


import java.util.Scanner

object Main {
  val in = new Scanner(System.in)

  def rotateMatrix(matrix: Array[Array[Long]], direction: Char): Unit = {
    val n = matrix.length
    var steps = 0
    for (layer <- 0 until n / 2) {
      for (i <- layer until n - layer - 1) {
        val temp = matrix(layer)(i)
        direction match {
          case 'L' =>
            matrix(layer)(i) = matrix(i)(n - layer - 1)
            matrix(i)(n - layer - 1) = matrix(n - layer - 1)(n - i - 1)
            matrix(n - layer - 1)(n - i - 1) = matrix(n - i - 1)(layer)
            matrix(n - i - 1)(layer) = temp
          case 'R' =>
            matrix(layer)(i) = matrix(n - i - 1)(layer)
            matrix(n - i - 1)(layer) = matrix(n - layer - 1)(n - i - 1)
            matrix(n - layer - 1)(n - i - 1) = matrix(i)(n - layer - 1)
            matrix(i)(n - layer - 1) = temp
          case _ =>
            throw new IllegalArgumentException("Invalid direction. Only 'R' or 'L' allowed.")
        }
        if (temp != matrix(layer)(i)) steps += 1
      }
    }
  }

  def solution(matrix: Array[Array[Long]], n: Int, direction: Char): (Int, List[Array[Int]]) = {
    @scala.annotation.tailrec
    def makeStep(permutations: List[Array[Int]] = List(), steps: Int = 0, i: Int, j: Int): (Int, List[Array[Int]]) = {
      if(i == n) (steps, permutations)
      else if(j == n) makeStep(permutations, steps, i+1, 0)
      else {
        val (i1, j1) = direction match {
          case 'R' => (n - j - 1, i)
          case 'L' => (j, n - i - 1)
        }
        if (matrix(i)(j) != matrix(i1)(j1)) {
          makeStep(Array(i1, j1, i, j) :: permutations, steps + 1, i, j+1)
        }
        else makeStep(permutations, steps, i, j+1)
      }
    }
    makeStep(i = 0, j = 0)
  }

  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val direction = in.next().charAt(0)
    val array = Array.ofDim[Long](n, n)
    for(i <- 0 until n) {
      for(j <-0 until n)
       array(i)(j) = in.nextLong()
    }
    val (count, stepsList) = solution(array, n, direction)
    println(count)
//    for {
//      row <- stepsList
//      _ = println(row.mkString(" "))
//    } ()
    rotateMatrix(array, direction)
    for {
      row <- array
      _ = println(row.mkString(" "))
    } ()
  }
}
