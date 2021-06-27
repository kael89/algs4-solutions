/* *****************************************************************************
 *  Exercise: 1.1.28
 *
 *  Description:
 *  ------------
 *  Remove duplicates. Modify the test client in BinarySearch to remove any duplicate keys
 *  in the whitelist after the sort.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_28 {
  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    whitelist = removeSortedDuplicates(whitelist);

    while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
      int key = StdIn.readInt();
      if (BinarySearch.rank(key, whitelist) < 0) {
        StdOut.println(key);
      }
    }
  }

  private static int[] removeSortedDuplicates(int[] array) {
    if (array.length < 2) {
      return copy(array, array.length);
    }

    int[] temp = new int[array.length];
    temp[0] = array[0];
    int j = 1;

    for (int i = 1; i < array.length; i++) {
      if (array[i] != array[i - 1]) {
        temp[j++] = array[i];
      }
    }

    return copy(temp, j);
  }

  private static int[] copy(int[] source, int length) {
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = source[i];
    }

    return result;
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
  }
}
