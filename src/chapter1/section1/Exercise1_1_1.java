/* *****************************************************************************
 *  Exercise: 1.1.1
 *
 *  Description:
 *  ------------
 *  Give the value of each of the following expressions:
 *  a. ( 0 + 15 ) / 2
 *  b. 2.0e-6 * 100000000.1
 *  c. true && false || true && true
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_1 {
  public static void main(String[] args) {
    StdOut.println((0 + 15) / 2); // 7
    StdOut.println(2.0e-6 * 100000000.1); // 200.0000002
    StdOut.println(true && false || true && true); // true
  }
}
