/* *****************************************************************************
 *  Exercise: 1.1.14
 *
 *  Description:
 *  ------------
 *  Write a static method lg() that takes an int value N as argument and returns
 *  the largest int not larger than the base-2 logarithm of N. Do not use Math.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_14 {
  public static void main(String[] args) {
    while (!StdIn.isEmpty()) {
      int n = StdIn.readInt();
      StdOut.println(lg(n));
    }
  }

  private static int lg(int n) {
    if (n < 0) {
      throw new Error("Input must be >= 0");
    }

    int log = 0;
    // noinspection StatementWithEmptyBody
    for (int i = 2; i <= n; i *= 2, log++) {
    }
    return log;
  }
}
