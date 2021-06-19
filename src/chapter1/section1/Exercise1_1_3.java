/* *****************************************************************************
 *  Exercise: 1.1.3
 *
 *  Description:
 *  ------------
 *  Write a program that takes three integer command-line arguments and prints
 *  equal if all three are equal, and not equal otherwise.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_3 {
  public static void main(String[] args) {
    int a = StdIn.readInt();
    int b = StdIn.readInt();
    int c = StdIn.readInt();

    boolean areEqual = a == b && b == c;
    StdOut.println(areEqual ? "equal" : "not equal");
  }
}
