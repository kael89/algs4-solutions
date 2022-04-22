/* *****************************************************************************
 *  Exercise: 1.4.6
 *
 *  Description:
 *  ------------
 *  Give the order of growth (as a function of N ) of the running times of each of the
 *  following code fragments:
 *
 *  a.
 *  int sum = 0;
 *  for (int n = N; n > 0; n /= 2)
 *    for(int i = 0; i < n; i++)
 *      sum++;
 *
 *  b.
 *  int sum = 0;
 *  for (int i = 1 i < N; i *= 2)
 *    for (int j = 0; j < i; j++)
 *      sum++;
 *
 *  c.
 *  int sum = 0;
 *  for (int i = 1 i < N; i *= 2)
 *    for (int j = 0; j < N; j++)
 *      sum++;
 **************************************************************************** */

package chapter1.section4;

public class Exercise1_4_6 {
  public static void main(String[] args) {
    /**
     * a. nlogn
     * b. n
     * c. nlogn
     */
  }
}
