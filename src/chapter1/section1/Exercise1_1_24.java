/* *****************************************************************************
 *  Exercise: 1.1.24
 *
 *  Description:
 *  ------------
 *  Give the sequence of values of p and q that are computed when Euclid’s algorithm is used to
 *  compute the greatest common divisor of 105 and 24. Extend the code given on page 4 to develop
 *  a program `Euclid` that takes two integers from the command line and computes their greatest
 *  common divisor, printing out the two arguments for each call on the recursive method.
 *  Use your program to compute the greatest common divisor or 1111111 and 1234567.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_24 {
  public static void main(String[] args) {
    int p = StdIn.readInt();
    int q = StdIn.readInt();

    gcd(p, q); // gcd(1111111, 1234567) == 1
  }

  public static int gcd(int p, int q) {
    StdOut.println(p + " " + q);
    if (q == 0) {
      return p;
    }
    int r = p % q;
    return gcd(q, r);
  }
}
