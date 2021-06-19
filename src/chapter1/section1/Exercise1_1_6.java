/* *****************************************************************************
 *  Exercise: 1.1.6
 *
 *  Description:
 *  ------------
 *  What does the following program print?
 *
 *  int f = 0;
 *  int g = 1;
 *  for (int i = 0; i <= 15; i++)
 *  {
 *    StdOut.println(f);
 *    f = f + g;
 *    g = f - g;
 *  }
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_6 {
  public static void main(String[] args) {
    // Answer: The first 15 numbers in Fibonacci sequence

    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}
