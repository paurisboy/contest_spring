package number1
import java.util.Scanner
object Main {
  val in = new Scanner(System.in)

  def solution(array: Array[Int], length: Int): Int ={
    val days = 7
    if(length < days) -1
    else {
      var i = 0
      var five_max = 0
      while (i < length - days + 1) {
        var j = 0
        var flag = true
        var curr_five = 0
        while (j < 7 && flag) {
          if (array(i + j) == 2 || array(i + j) == 3) {
            flag = false
            curr_five = 0
            i = i + j
          }
          else if (array(i + j) == 5) curr_five += 1
          j += 1
        }
        if (curr_five > five_max) five_max = curr_five
        i += 1
      }
      if (five_max == 0) -1
      else five_max
    }
  }

  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val array = new Array[Int](n)
    for(i <- 0 until n) array(i) = in.nextInt()
    println(solution(array, n))
  }
}
