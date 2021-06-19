/* *****************************************************************************
 *  Exercise: 1.1.15
 *
 *  Description:
 *  ------------
 *  Write a static method histogram() that takes an array a[] of int values and
 *  an integer M as arguments and returns an array of length M whose ith entry is the number of
 *  times the integer i appeared in the argument array. If the values in a[] are all
 *  between 0 and M–1, the sum of the values in the returned array should be equal to
 *  a.length.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_15 {

  public static void main(String[] args) {
    StdOut.println("Please provide the histogram length (m):");
    int m = StdIn.readInt();
    StdOut.println("Please provide an array of integers:");
    int[] a = StdIn.readAllInts();

    int[] histogram = histogram(a, m);
    StdArrayIO.print(histogram);
  }

  private static int[] histogram(int[] a, int m) {
    int[] result = new int[m];

    for (int i = 0; i < a.length; i++) {
      if (a[i] >= m) {
        continue;
      }

      result[a[i]]++;
    }

    return result;
  }
}
