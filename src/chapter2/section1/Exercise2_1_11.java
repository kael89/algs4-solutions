/* *****************************************************************************
 *  Exercise: 2.1.11
 *
 *  Description:
 *  ------------
 *  Implement a version of shell sort that keeps the increment sequence in an array,
 *  rather than computing it.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2_1_11 {

  public static void main(String[] args) {
    StdOut.print("n: ");
    int n = StdIn.readInt();
    StdOut.println();
    Double[] a = createRandomArray(n);

    StdOut.println("Input:");
    printArray(a);
    StdOut.println();

    StdOut.println("Result:");
    new ShellSort<Double>().sort(a);
    printArray(a);
  }

  private static Double[] createRandomArray(int n) {
    Double[] a = new Double[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(0.0, 1.0);
    }

    return a;
  }

  private static void printArray(Double[] a) {
    for (double item : a) {
      StdOut.println(item);
    }
  }

  public static class ShellSort<T extends Comparable<T>> extends Sort<T> {
    private static final int[] H_SEQUENCE = new int[]{
        1, 4, 13, 40, 121, 364, 1903, 5710, 17131, 51394
    };

    private static final int MAX_SORTABLE_SIZE = H_SEQUENCE[H_SEQUENCE.length - 1] * 3 + 2;

    public void sort(T[] a) {
      for (int hIndex = getInitialHIndexForArray(a); hIndex >= 0; hIndex--) {
        int h = H_SEQUENCE[hIndex];
        for (int i = h; i < a.length; i++) {
          for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
            exchange(a, j, j - h);
          }
        }
      }
    }

    private int getInitialHIndexForArray(T[] a) {
      int i = 0;
      for (; i < H_SEQUENCE.length; i++) {
        if (H_SEQUENCE[i] >= a.length / 3) {
          break;
        }
      }

      if (i == H_SEQUENCE.length) {
        throw new Error("Maximum sortable array size reached: " + MAX_SORTABLE_SIZE);
      }

      return i;
    }
  }
}
