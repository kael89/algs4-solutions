/* *****************************************************************************
 *  Exercise: 1.4.9
 *
 *  Description:
 *  ------------
 *  Give a formula to predict the running time of a program for a problem of size N
 *  when doubling experiments have shown that the doubling factor is 2^b and the running
 *  time for problems of size n0 is t.
 **************************************************************************** */

package chapter1.section4;

public class Exercise1_4_9 {
  public static void main(String[] args) {
    /**
     * Answer:
     * If the doubling factor is 2^b, we assume that the running time is ~ a * n^b
     * For n = n0, a * n0^b = t
     * For n = N, a * N^b = a * (n0 * N / n0)^b = a * n0^b * (N / n0)^b = t * (N / n0)^b
     *
     * Example:
     * If b = 3 and for n1 = 16 => t1 = 100 secs,
     * for n2 = 128 => t2 = 100 * (128 / 16)^ 3 = 100 * 8^3 = 51200 secs
     */
  }
}
