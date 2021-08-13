/* *****************************************************************************
 *  Exercise: 2.1.6
 *
 *  Description:
 *  ------------
 *  Which method runs faster for an array with all keys identical, selection sort or
 *  insertion sort?
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_6 {
  public static void main(String[] args) {
    // (Note: 1 compare = 2 array accesses, 1 exchange = 4 array accesses)
    //
    // For an array with all keys identical:
    //
    // Selection sort will execute
    // - n * (n - 1) / 2 compares => n * (n - 1) acc.
    // - n exchanges (each element with itself) => 4 * n acc.
    // Total: n^2 + 3 * n accesses
    // (as always - array accesses in selection sort are independent of the element arrangement)
    //
    // Insertion sort will execute
    // - n - 1 compares
    // - 0 exchanges
    // Total: 2 * (n - 1) accesses
    //
    // Thus, insertion sort will be much faster than selection sort in this case.
  }
}
