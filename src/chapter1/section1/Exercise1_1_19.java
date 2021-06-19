/* *****************************************************************************
 *  Exercise: 1.1.19
 *
 *  Description:
 *  ------------
 *  Run the following program on your computer:
 *
 *  public class Fibonacci
 *  {
 *    public static long F(int N)
 *    {
 *      if (N == 0) return 0;
 *      if (N == 1) return 1;
 *      return F(N-1) + F(N-2);
 *    }
 *
 *    public static void main(String[] args)
 *    {
 *      for (int N = 0; N < 100; N++)
 *      StdOut.println(N + " " + F(N));
 *    }
 *  }
 *
 *  What is the largest value of N for which this program takes less 1 hour to compute the
 *  value of F(N)? Develop a better implementation of F(N) that saves computed values in
 *  an array
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise1_1_19 {
  public static void main(String[] args) {

    StdOut.println("Recursive method");
    int recDurationInSecs = (int) (readRecursiveDurationInMins(args) * 60);
    int maxRecursiveN = runFibonacciRecursive(recDurationInSecs);
    printElapsedTime(recDurationInSecs);
    StdOut.println();

    StdOut.println("Using Array");
    int secsElapsed = runFibonacciUsingArray(maxRecursiveN);
    printElapsedTime(secsElapsed);
  }

  private static double readRecursiveDurationInMins(String[] args) {
    if (args.length == 0) {
      throw new Error("Please specify the max program duration in minutes");
    }
    return Double.parseDouble(args[0]);
  }

  private static void printElapsedTime(int secs) {
    StdOut.println("Time elapsed: " + secs + " seconds");
  }

  private static int runFibonacciRecursive(int durationInSecs) {
    Stopwatch timer = new Stopwatch();

    int n = 0;
    while (true) {
      long fib = fibRecursive(n);
      if (timer.elapsedTime() >= durationInSecs) {
        break;
      }

      StdOut.println(n + " " + fib);
      n++;
    }

    return n;
  }

  private static long fibRecursive(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
  }

  private static int runFibonacciUsingArray(int maxN) {
    Stopwatch timer = new Stopwatch();

    long[] fibs = new long[maxN + 1];
    fibs[0] = 0;
    fibs[1] = 1;

    int n = 0;
    while (n <= maxN) {
      if (n > 1) {
        fibs[n] = fibs[n - 1] + fibs[n - 2];
      }

      StdOut.println(n + " " + fibs[n]);
      n++;
    }

    return (int) timer.elapsedTime();
  }
}
