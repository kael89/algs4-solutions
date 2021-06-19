/* *****************************************************************************
 *  Exercise: 1.1.16
 *
 *  Description:
 *  ------------
 *  Give the value of exR1(6):
 *  public static String exR1(int n)
 *  {
 *    if (n <= 0) return "";
 *    return exR1(n-3) + n + exR1(n-2) + n;
 *  }
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_16 {
  public static void main(String[] args) {
    StdOut.println(exR1(6)); // 31161142246
  }

  public static String exR1(int n) {
    if (n <= 0) {
      return "";
    }
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }
}
