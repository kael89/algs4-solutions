/* *****************************************************************************
 *  Exercise: 2.1.5
 *
 *  Description:
 *  ------------
 *  For each of the two conditions in the inner for loop in insertion sort (Algorithm 2.2),
 *  describe an array of N items where that condition is always false when the loop terminates
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_5 {
  public static void main(String[] args) {
    // Answer
    // * For j > 0: array sorted in reverse order, e.g. G F E D C B A
    // * For less(a[j], a[j-1]): array sorted in correct order, e.g. A B C D E F G
  }
}
