/* *****************************************************************************
 *  Exercise: 1.1.20
 *
 *  Description:
 *  ------------
 *  Write a recursive static method that computes the value of ln (N !)
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_20 {
  public static void main(String[] args) {
    while (!StdIn.isEmpty()) {
      int n = StdIn.readInt();
      StdOut.println(lnFactorial(n));
    }
  }

  private static double lnFactorial(int n) {
    return n == 1 ? 0 : Math.log(n) + lnFactorial(n - 1);
  }
}
