/* *****************************************************************************
 *  Exercise: 1.1.29
 *
 *  Description:
 *  ------------
 *  Equal keys. Add to BinarySearch a static method rank() that takes a key and
 *  a sorted array of int values (some of which may be equal) as arguments and returns the
 *  number of elements that are smaller than the key and a similar method count() that
 *  returns the number of elements equal to the key. Note : If i and j are the values returned
 *  by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
 *  the array that are equal to key
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_29 {
  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);

    StdOut.println("Sorted whitelist:");
    printWhitelist(whitelist);
    StdOut.println("Please provide a search key: ");

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      StdOut.println("Smaller: " + BinarySearch.countSmaller(key, whitelist));
      StdOut.println("Equal: " + BinarySearch.countEqual(key, whitelist));
      StdOut.println();
      StdOut.println("Please provide a search key: ");
    }
  }

  private static void printWhitelist(int[] whitelist) {
    for (int item : whitelist) {
      StdOut.print(item + " ");
    }
    StdOut.printf("(length: %d)\n", whitelist.length);
  }

  private static class BinarySearch {
    public static int rank(int key, int[] a) { // Array must be sorted.
      int lo = 0;
      int hi = a.length - 1;

      while (lo <= hi) { // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
          hi = mid - 1;
        } else if (key > a[mid]) {
          lo = mid + 1;
        } else {
          return mid;
        }
      }
      return -1;
    }

    public static int countSmaller(int key, int[] a) { // Array must be sorted.
      if (a.length == 0 || key < a[0]) {
        return 0;
      }
      if (key > a[a.length - 1]) {
        return a.length;
      }

      int lo = 0;
      int hi = a.length - 1;
      int countSmaller = 0;

      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
          hi = mid - 1;
        } else if (key > a[mid]) {
          lo = mid + 1;
          countSmaller = lo;
        } else {
          return mid - countEqualPrevious(a, mid);
        }
      }

      return countSmaller;
    }

    public static int countEqual(int key, int[] a) { // Array must be sorted.
      if (a.length == 0 || key < a[0] || key > a[a.length - 1]) {
        return 0;
      }

      int rank = BinarySearch.rank(key, a);
      return rank == -1 ? 0 : 1 + countEqualPrevious(a, rank) + countEqualNext(a, rank);
    }

    private static int countEqualPrevious(int[] a, int index) {
      int count = 0;
      for (int i = index - 1; i >= 0; i--) {
        if (a[i] != a[index]) {
          break;
        }
        count++;
      }

      return count;
    }

    private static int countEqualNext(int[] a, int index) {
      int count = 0;
      for (int i = index + 1; i < a.length; i++) {
        if (a[i] != a[index]) {
          break;
        }
        count++;
      }

      return count;
    }
  }
}
