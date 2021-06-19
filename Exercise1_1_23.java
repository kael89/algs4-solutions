/* *****************************************************************************
 *  Exercise: 1.1.23
 *
 *  Description:
 *  ------------
 *  Add to the BinarySearch test client the ability to respond to a second argument:
 *  + to print numbers from standard input that are not in the whitelist,
 *  - to print numbers that are in the whitelist
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_23 {
  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    boolean printIfInWhitelist = readPrintIfInWhitelist(args);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int rank = BinarySearch.rank(key, whitelist) * (printIfInWhitelist ? -1 : 1);
      if (rank < 0) {
        StdOut.println(key);
      }
    }
  }

  private static boolean readPrintIfInWhitelist(String[] args) {
    boolean printIfInWhitelist = false;

    if (args.length > 1) {
      if (args[1].equals("+")) {
        printIfInWhitelist = false;
      } else if (args[1].equals("-")) {
        printIfInWhitelist = true;
      } else {
        throw new Error("Invalid second argument provided, must be one of +, -");
      }
    }

    return printIfInWhitelist;
  }

  private static class BinarySearch {
    public static int rank(int key, int[] a) {
      return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
      if (lo > hi) {
        return -1;
      }
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        return rank(key, a, lo, mid - 1);
      } else if (key > a[mid]) {
        return rank(key, a, mid + 1, hi);
      } else {
        return mid;
      }
    }
  }
}
