/* *****************************************************************************
 *  Exercise: 1.1.7
 *
 *  Description:
 *  ------------
 *  Give the value printed by each of the following code fragments:
 *  a.
 *    double t = 9.0;
 *    while (Math.abs(t - 9.0/t) > .001)
 *      t = (9.0/t + t) / 2.0;
 *    StdOut.printf("%.5f\n", t);
 *
 *  b.
 *    int sum = 0;
 *    for (int i = 1; i < 1000; i++)
 *      for (int j = 0; j < i; j++)
 *        sum++;
 *    StdOut.println(sum);
 *
 *  c.
 *    int sum = 0;
 *    for (int i = 1; i < 1000; i *= 2)
 *      for (int j = 0; j < N; j++)
 *        sum++;
 *    StdOut.println(sum);
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_7 {
  public static void main(String[] args) {
    int n = StdIn.readInt();

    printA(); // An approximation of sqrt(9) (delta: 0.001)
    printB(); // Sum of simple linear sequence in [1, 999] => (1 + 999) * (999 - 1 + 1) / 2 => 499,500
    printC(n); // n * (log(2)999 + 1) => 10n
  }

  private static void printA() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f\n", t);
  }

  private static void printB() {
    int sum = 0;
    for (int i = 1; i < 1000; i++)
      for (int j = 0; j < i; j++)
        sum++;
    StdOut.println(sum);
  }

  private static void printC(int n) {
    int sum = 0;
    for (int i = 1; i < 1000; i *= 2)
      for (int j = 0; j < n; j++)
        sum++;
    StdOut.println(sum);
  }
}
