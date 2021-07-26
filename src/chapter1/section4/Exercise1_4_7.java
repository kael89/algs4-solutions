/* *****************************************************************************
 *  Exercise: 1.4.7
 *
 *  Description:
 *  ------------
 *  Analyze ThreeSum under a cost model that counts arithmetic operations (and
 *  comparisons) involving the input numbers
 **************************************************************************** */

package chapter1.section4;

public class Exercise1_4_7 {
  public static void main(String[] args) {

  }

  /**
   * Arithmetic operations involving the input numbers are performed in statement block E.
   * This block is executed exactly n * (n - 1 ) * (n - 2) / 6 times, as mentioned in the textbook.
   * Each time 2 additions and one comparison are executed, to a total of n * (n - 1) * (n - 2) / 2
   * Tilde approximation: n^3 / 2
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
        for (int k = j + 1; k < n; k++) {
          // E
          if (a[i] + a[j] + a[k] == 0) {
            count++;
          }
        }
      }
    }
  }
}
