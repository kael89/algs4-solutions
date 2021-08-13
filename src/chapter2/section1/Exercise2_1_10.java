/* *****************************************************************************
 *  Exercise: 2.1.0
 *
 *  Description:
 *  ------------
 *  Why not use selection sort for h-sorting in shellsort?
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_10 {
  public static void main(String[] args) {
    // Answer: we could, but insertion sort is faster than selection sort on the average case for an
    // array, and the same would apply to the h-sortable sub-arrays which are the fundamental block
    // of shellsort
  }
}
