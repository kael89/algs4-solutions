/* *****************************************************************************
 *  Exercise: 1.1.27
 *
 *  Description:
 *  ------------
 *  Binomial distribution. Estimate the number of recursive calls that would be
 *  used by the code
 *
 *  public static double binomial(int N, int k, double p)
 *  {
 *    if ((N == 0) || (k < 0)) return 1.0;
 *    return (1.0 - p)*binomial(N-1, k) + p*binomial(N-1, k-1);
 *  }
 *
 *  to compute binomial(100, 50, 0.25). Develop a better implementation that is based on
 *  saving computed values in an array
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise1_1_27 {
  private static Stats recursionStats = new Stats("Using recursion");

  private static Stats arrayStats = new Stats("Using array");

  private static Object[][] cache;

  public static void main(String[] args) {
    int n = StdIn.readInt();
    int k = StdIn.readInt();
    double p = StdIn.readDouble();

    recursionStats.startTimer();
    double recursionResult = binomialRecursion(n, k, p);
    recursionStats.submitResult(recursionResult);
    recursionStats.print();
    StdOut.println();

    arrayStats.startTimer();
    cache = createCache(n, k);
    double arrayResult = binomialArray(n, k, p);
    arrayStats.submitResult(arrayResult);
    arrayStats.print();
  }

  private static double binomialRecursion(int n, int k, double p) {
    recursionStats.incrementCount();

    if (n == 0 && k == 0) {
      return 1.0;
    }
    if (n < 0 || k < 0) {
      return 0.0;
    }
    return (1.0 - p) * binomialRecursion(n - 1, k, p) + p * binomialRecursion(n - 1, k - 1, p);
  }

  private static double binomialArray(int n, int k, double p) {
    arrayStats.incrementCount();

    if (n == 0 && k == 0) {
      return 1.0;
    }
    if (n < 0 || k < 0) {
      return 0.0;
    }

    if (n == 0 || k == 0) {
      return (1.0 - p) * binomialArray(n - 1, k, p);
    }

    if (cache[n - 1][k] == null) {
      cache[n - 1][k] = binomialArray(n - 1, k, p);
    }
    if (cache[n - 1][k - 1] == null) {
      cache[n - 1][k - 1] = binomialArray(n - 1, k - 1, p);
    }

    return (1.0 - p) * (double) cache[n - 1][k] + p * (double) cache[n - 1][k - 1];
  }

  private static Object[][] createCache(int n, int k) {
    cache = new Object[n + 1][k + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        cache[0][0] = null;
      }
    }
    cache[0][0] = 1.0;

    return cache;
  }

  private static class Stats {
    private final String name;

    private long iterationCount = 0;

    private double result;

    private Stopwatch stopwatch;

    public Stats(String name) {
      this.name = name;
    }

    private static String repeat(String string, int count) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < count; i++) {
        sb.append(string);
      }
      return sb.toString();
    }

    public void incrementCount() {
      this.iterationCount++;
    }

    public void startTimer() {
      stopwatch = new Stopwatch();
    }

    public void submitResult(double result) {
      this.result = result;
    }

    public void print() {
      if (stopwatch == null) {
        throw new Error("You must submit results first before printing them!");
      }

      StdOut.println(name);
      StdOut.printf(repeat("-", name.length()) + "\n");
      StdOut.printf("Result: %f\n", result);
      StdOut.printf("Iteration count: %,d\n", iterationCount);
      StdOut.printf("Duration: %.3f secs\n", stopwatch.elapsedTime());
    }
  }
}
