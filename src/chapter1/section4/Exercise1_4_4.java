/* *****************************************************************************
 *  Exercise: 1.4.5
 *
 *  Description:
 *  ------------
 *  Develop a table like the one on page 181 for TwoSum
 **************************************************************************** */

package chapter1.section4;

public class Exercise1_4_4 {
  public static void main(String[] args) {
  }

  /**
   * Cost analysis
   *
   * | block     | time (secs) | frequency            | total time           |
   * | --------- | ----------- | -------------------- | -------------------- |
   * | D         | t0          | x (depends on input) | t0 * x               |
   * | C         | t1          | n * (n - 1) / 2      | t1 * (n^2 / 2 - n/2) |
   * | B         | t2          | n                    | t2 * n               |
   * | A         | t3          | 1                    | t3                   |
   *
   * Grand total:         (t1 / 2) * n^2 + (t2 - t1 / 2) * n + t3 + t0 * x
   * Tilde approximation: ~ (t1 / 2) * n^2
   * Order of growth:     n^2
   */
  public static void twoSum(int[] a) {
    // A
    int n = a.length;
    int count = 0;

    // B
    for (int i = 0; i < n; i++) {
      // C
      for (int j = i + 1; j < n; j++) {
        // D
        if (a[i] + a[j] == 0) {
          count++;
        }
      }
    }
  }
}
