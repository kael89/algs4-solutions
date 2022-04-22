/* *****************************************************************************
 *  Exercise: 1.4.8
 *
 *  Description:
 *  ------------
 *  Write a program to determine the number pairs of values in an input file that
 *  are equal. If your first try is quadratic, think again and use Arrays.sort() to develop
 *  a linearithmic solution.
 **************************************************************************** */

package chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_4_8 {
  public static void main(String[] args) {
    int[] a = (new In(args[0])).readAllInts();
    StdOut.println("Equal pairs: " + countEqualPairs(a));
  }

  private static int countEqualPairs(int[] a) {
    Arrays.sort(a);

    int count = 0;
    int pairCount = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] == a[i + 1]) {
        pairCount++;
        count += pairCount;
      } else {
        pairCount = 0;
      }
    }

    return count;
  }
}
