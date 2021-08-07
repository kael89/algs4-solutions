/* *****************************************************************************
 *  Exercise: 1.4.12
 *
 *  Description:
 *  ------------
 *  Write a program that, given two sorted arrays of N int values, prints all elements that appear
 *  in both arrays, in sorted order. The running time of your program should be proportional
 *  to N in the worst case.
 **************************************************************************** */

package chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_4_12 {
  public static void main(String[] args) {
    int[] a = new In(args[0]).readAllInts();
    int[] b = new In(args[1]).readAllInts();
    Arrays.sort(a);
    Arrays.sort(b);

    logIntersection(a, b);
  }

  /**
   * Logs all elements in a that also appear in b, in sorted order
   * Precondition: `a` and `b` are sorted
   *
   * ----------------------
   * Worst case complexity:
   * ----------------------
   * If our cost model is counting array accesses, then worst case complexity is 6N - 1
   * for arrays that include elements like the following:
   * a: 2 4 6 8
   * b: 1 3 5 7
   *
   * We consider this case to
   * be worst since it seems to be the one that moves slower
   * through items of each array, and covers all items of both arrays
   *
   * Analysis
   * --------
   * For each sub-array like the following:
   * a: 2 4
   * b: 1 3 5
   *
   * the following accesses will occur: (2, 1), (2, 3), (4, 3), (4, 5)
   * For each pair (x1, x2):
   * * x1 < x2 => 1 comparison
   * * x1 > x2 => 2 comparisons
   * Total: 6 comp. * 2 acc. = 12 acc.
   * N: 2 items each array => 12 acc. = 6N acc.
   *
   * The last sub-array will require one less comparison (in our example above, we wouldn't need
   * to compare (4, 5), so in this case we have 5 comp. * 2 acc. = 10 acc. => 5N acc.
   *
   * Total: 6(N - 1) + 5 = 6N - 1
   */
  private static void logIntersection(int[] a, int[] b) {
    int i = 0;
    int j = 0;

    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        i++;
      } else if (a[i] > b[j]) {
        j++;
      } else {
        StdOut.print(a[i] + " ");
        j++;
        i++;
      }
    }

    StdOut.println();
  }
}
