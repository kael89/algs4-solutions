/* *****************************************************************************
 *  Exercise: 2.1.31
 *
 *  Description:
 *  ------------
 *  Doubling test. Write a client that performs a doubling test for sort algorithms.
 *  Start at n equal to 1000, and print n, the predicted number of seconds, the actual number of
 *  seconds, and the ratio as doubles. Use your program to validate that insertion sort and
 *  selection sort are quadratic for random inputs, and formulate and test a hypothesis
 *  for shellsort.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise2_1_31 {
  public static void main(String[] args) {
    StdOut.println("Doubling test for selection sort");
    SelectionSort<Double> selectionSort = new SelectionSort<Double>();
    runBenchmark(selectionSort);
    StdOut.println();

    StdOut.println("Doubling test for insertion sort");
    InsertionSort<Double> insertionSort = new InsertionSort<Double>();
    runBenchmark(insertionSort);
    StdOut.println();

    StdOut.println("Doubling test for shell sort");
    ShellSort<Double> shellSort = new ShellSort<Double>();
    runBenchmark(shellSort);
  }

  public static void runBenchmark(Sort<Double> sortInstance) {
    double previousTime = 1;
    double previousRatio = 1;

    for (int n = 250; n < 512000; n += n) {
      double prediction = previousRatio * previousTime;
      Double[] array = ArrayHelpers.generateRandom(n);
      Stopwatch timer = new Stopwatch();
      sortInstance.sort(array);
      double actualTime = timer.elapsedTime();

      double ratio = actualTime / previousTime;
      if (n >= 1000) {
        StdOut.printf("n: %8d, prediction: %5.2f secs, actual: %5.2f secs, ratio: %.2f\n", n,
                      prediction,
                      actualTime, ratio);
      }
      previousTime = actualTime;
      previousRatio = ratio;
    }
  }
}
