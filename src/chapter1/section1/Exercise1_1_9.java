/* *****************************************************************************
 *  Exercise: 1.1.9
 *
 *  Description:
 *  ------------
 *  Write a code fragment that puts the binary representation of a positive integer N
 *  into a String s.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_9 {
  public static void main(String[] args) {
    while (!StdIn.isEmpty()) {
      intToBinaryString();
    }
  }

  private static void intToBinaryString() {
    int n = StdIn.readInt();

    StringBuilder sb = new StringBuilder();
    do {
      sb.append(n % 2);
      n /= 2;
    } while (n > 0);

    StdOut.println(sb.reverse());
  }
}
