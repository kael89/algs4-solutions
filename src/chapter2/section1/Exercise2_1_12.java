/* *****************************************************************************
 *  Exercise: 2.1.12
 *
 *  Description:
 *  ------------
 *  Instrument shellsort to print the number of compares divided by the array size
 *  for each increment. Write a test client that tests the hypothesis that this number is a
 *  small constant, by sorting arrays of random Double values, using array sizes that are
 *  increasing powers of 10, starting at 100.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2_1_12 {
  public static void main(String[] args) {
    int i = 1;
    while (true) {
      i *= 10;
      Double[] a = createRandomArray(i);
      new ShellSort<Double>().sort(a);
    }
  }

  private static Double[] createRandomArray(int n) {
    Double[] a = new Double[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(0.0, 1.0);
    }

    return a;
  }

  public static class ShellSort<T extends Comparable<T>> extends Sort<T> {
    private static final int[] H_SEQUENCE = new int[]{
        1, 4, 13, 40, 121, 364, 1903, 5710, 17131, 51394, 154183, 462547, 1387642
    };

    private static final int MAX_SORTABLE_SIZE = H_SEQUENCE[H_SEQUENCE.length - 1] * 3 + 2;

    private int compares = 0;

    public void sort(T[] a) {
      this.initStats();

      int initialHIndex = getInitialHIndexForArray(a);
      for (int hIndex = initialHIndex; hIndex >= 0; hIndex--) {
        int h = H_SEQUENCE[hIndex];
        for (int i = h; i < a.length; i++) {
          for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
            exchange(a, j, j - h);
          }
        }
      }

      double comparesPerItemAndH = (double) compares / a.length / (initialHIndex + 1);
      StdOut.printf("n: %12d, compares per item/increment: %.2f\n", a.length, comparesPerItemAndH);
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

    private void initStats() {
      compares = 0;
    }

    protected void exchange(T[] a, int i, int j) {
      super.exchange(a, i, j);
      compares++;
    }
  }
}
