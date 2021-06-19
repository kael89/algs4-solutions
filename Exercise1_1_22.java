/* *****************************************************************************
 *  Exercise: 1.1.22
 *
 *  Description:
 *  ------------
 *  Write a version of BinarySearch that uses the recursive rank() given on page
 *  25 and traces the method calls. Each time the recursive method is called,
 *  print the argument values lo and hi, indented by the depth of the recursion.
 *  Hint: Add an argument to the recursive method that keeps track of the depth.
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_22 {
  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (BinarySearch.rank(key, whitelist) < 0) {
        StdOut.println("Not found: " + key);
      } else {
        StdOut.println("Found: " + key);
      }
    }
  }

  private static class BinarySearch {
    public static int rank(int key, int[] a) {
      return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
      return rank(key, a, lo, hi, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
      StdOut.printf("%" + (depth * 2) + "s %s\n", lo, hi);

      if (lo > hi) {
        return -1;
      }
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        return rank(key, a, lo, mid - 1, depth + 1);
      } else if (key > a[mid]) {
        return rank(key, a, mid + 1, hi, depth + 1);
      } else {
        return mid;
      }
    }
  }
}
