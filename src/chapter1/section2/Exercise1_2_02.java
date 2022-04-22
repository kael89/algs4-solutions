/* *****************************************************************************
 *  Exercise: 1.2.2
 *
 *  Description:
 *  ------------
 *  Write an Interval1D client that takes an int value N as command-line argument
 *  reads N intervals (each defined by a pair of double values) from standard input,
 *  and prints all pairs that intersect.
 **************************************************************************** */

package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_2 {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    StdOut.printf("Give %d intervals as pairs of double values:\n", n);

    Interval1D[] intervals = readIntervals(n);
    printIntersectingIntervals(intervals);
  }

  private static Interval1D[] readIntervals(int n) {
    Interval1D[] intervals = new Interval1D[n];
    for (int i = 0; i < n; i++) {
      intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
    }
    return intervals;
  }

  private static void printIntersectingIntervals(Interval1D[] intervals) {
    System.out.println("Intersecting interval pairs: ");
    for (int i = 0; i < intervals.length; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        if (intervals[i].intersects(intervals[j])) {
          StdOut.println(intervals[i] + ", " + intervals[j]);
        }
      }
    }
  }
}
