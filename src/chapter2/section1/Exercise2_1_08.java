/* *****************************************************************************
 *  Exercise: 2.1.8
 *
 *  Description:
 *  ------------
 *  Suppose that we use insertion sort on a randomly ordered array where elements have only one of
 *  three values. Is the running time linear, quadratic, or something in between?
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_8 {
  public static void main(String[] args) {
    // Best case scenario
    // ------------------
    // All items are the same. In this case, we have
    // - n - 1 compares
    // - 0 exchanges
    //
    // Worst case scenario
    // -------------------
    // We will now try to construct a worst case scenario. In general, the worst case scenario for
    // insertion sort is for arrays sorted in reverse order (~n^2 compares and ~n^2/2 exchanges).
    // We can combine this fact with the limitation of "only one of three values" to
    // construct an array like the following:
    //  3 3 3 ... 3 3 3  2 2 2 ... 2 2 2   1 1 1 ... 1 1 1
    // | --- n/3 times | -- n/3 times -- | -- n/3 times -- |
    //
    // While we don't prove that this is the worst case scenario under the specific conditions,
    // we can show that it results in the same order of growth as the general worst case scenario
    // (which is the upper bound for insertion sort).
    //
    // - When processing all 3s, we have
    //   - 1 + 2 + ... (n - 1) / 3 = ~ n^2 / 18 compares
    //   - 0 exchanges
    //
    // - When processing all 2s, we have
    //   - n / 3 * (n / 3 + 1) - 1 compares (each of the 2s shifts across all 3s to the left.
    //     The first will be compared with all 3s, the others with all 3s + one 2)
    //     = ~ n^2 / 9 compares
    //   - n / 3 * n / 3 = n^2 / 9 exchanges
    //
    // - When processing all 1s, we have
    //   - n / 3 * ( 2 * n / 3 + 1) - 1 compares (each of the 1s shifts across all 3s/2s to the left.
    //     The first will be compared with all 3s/2s, the others with all 3s/2s + one 1)
    //     = ~ 2 n^2 / 9 compares
    //   - n / 3 * (2 * n / 3) = 2 * n^2 / 9 exchanges
    //
    // Total:
    // - ~ 7 * n^2 / 18 compares (close to n^2 / 3)
    // - n^2 / 3 exchanges
    //
    // Average case
    // ------------
    // - ~ 7 * n^2 / 36 compares (close to n^2 / 6)
    // - n^2 / 6 exchanges
    // Thus, we conclude that the running time is still quadratic (albeit the
    // "only one of three values" seemingly makes it faster than the general case)
  }
}
