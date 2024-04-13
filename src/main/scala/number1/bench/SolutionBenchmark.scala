package number1.bench

import number1.Main
import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
class SolutionBenchmark {
  val testDataSize = 100000
  val testData: Array[Int] = Array.fill(testDataSize)(scala.util.Random.nextInt(4) + 2)

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def solutionBenchmark(): Int = {
    Main.solution(testData, testDataSize)
  }
}
