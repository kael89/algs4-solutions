/* *****************************************************************************
 *  Exercise: 1.1.5
 *
 *  Description:
 *  ------------
 *  Write a code fragment that prints true if the double variables x and y are both
 *  strictly between 0 and 1 and false otherwise.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_5 {
  public static void main(String[] args) {
    double a = StdIn.readDouble();
    double b = StdIn.readDouble();

    StdOut.println(inRange(a) && inRange(b));
  }

  private static boolean inRange(double a) {
    return a >= 0 && a <= 1;
  }
}
