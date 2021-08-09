/* *****************************************************************************
 *  Exercise: 2.1.7
 *
 *  Description:
 *  ------------
 *  Which method runs faster for an array in reverse order, selection sort or insertion sort?
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_7 {
  public static void main(String[] args) {
    // (Note: 1 compare = 2 array accesses, 1 exchange = 4 array accesses)
    //
    // For an array in reverse order:
    //
    // Selection sort will execute
    // - n * (n - 1) / 2 compares => n * (n - 1) acc.
    // - n exchanges (each element with itself) => 4 * n acc.
    // Total: n^2 + 3 * n accesses
    // (as always - array accesses in selection sort are independent of the element arrangement)
    //
    // Insertion sort will execute
    // - 1 + 2 + ... n - 1 = n * (n - 1) / 2 compares => n * (n - 1) acc.
    // - n * (n - 1 ) / 2 exchanges (each compare results in an exchange) => 2 * n * (n - 1 ) acc.
    // Total: 3 * n^2 - 3 * n accesses
    //
    // Thus, insertion sort will be ~ 3 times slower than selection sort
    // (due to the redundant exchanges)
  }
}
