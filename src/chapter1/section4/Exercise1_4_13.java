/* *****************************************************************************
 *  Exercise: 1.4.13
 *
 *  Description:
 *  ------------
 *  Using the assumptions developed in the text, give the amount of memory needed
 *  to represent an object of each of the following types:
 *  a. Accumulator
 *  b. Transaction
 *  c. FixedCapacityStackOfStrings with capacity C and N entries
 *  d. Point2D
 *  e. Interval1D
 *  f. Interval2D
 *  g. Double
 **************************************************************************** */

package chapter1.section4;

public class Exercise1_4_13 {
  public static void main(String[] args) {
    /**
     * Answer
     * ------
     * Note: for each object, memory needed to
     * represent each object variable is not taken into account
     * This is because object references may be shared, eg many Transaction objects may share a
     * reference to a single Date
     *
     *  a. Accumulator
     *  Source: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Accumulator.java.html
     *  - object overhead: 16
     *  - 1 int instance var: 4
     *  - 2 double instance vars: 2 * 8 = 16
     *  Total: 36 + padding => 40 bytes
     *
     *  b. Transaction
     *  Source: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Transaction.java.html
     *  - object overhead: 16
     *  - 1 String instance var: 8
     *  - 1 Date instance var: 8
     *  - 1 double instance var: 8
     *  Total: 40 bytes
     *
     *  c. FixedCapacityStackOfStrings with capacity C and N entries
     *  Source: https://algs4.cs.princeton.edu/13stacks/FixedCapacityStackOfStrings.java.html
     *  - object overhead: 16
     *  - 1 String[] array of capacity C with N entries:
     *    - array overhead: 24
     *    - String references: 8 * C (pre-allocates memory for its full capacity)
     *    Total: 24 + 8 * C
     *  - 1 int instance var: 4
     *  Total:
     *    20 + (24 + 8 * C) = 44 + 8 * C (not a multiple of 8, so need to add padding) =>
     *    + padding = 48 + 8 * C
     *
     *  d. Point2D
     *  Source: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Point2D.java.html
     *  - object overhead: 16
     *  - 2 double instance vars: 2 * 8 = 16
     *  Total: 32 bytes
     *
     *  e. Interval1D
     *  Source: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Interval1D.java.html
     *  - object overhead: 16
     *  - 2 double instance vars: 2 * 8 = 16
     *  Total: 32 bytes
     *
     *  f. Interval2D
     *  Source: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Interval2D.java.html
     *  - object overhead: 16
     *  - 2 Interval1D instance vars: 2 * 8 (reference)
     *  Total: 32 bytes
     *
     *  g. Double
     *  - object overhead: 16
     *  - `double` instance variable: 4
     *  Total: 20 + padding = 24 bytes
     */
  }
}
