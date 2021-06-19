/* *****************************************************************************
 *  Exercise: 1.1.18
 *
 *  Description:
 *  ------------
 *  Consider the following recursive function:
 *
 *  public static int mystery(int a, int b)
 *  {
 *    if (b == 0) return 0;
 *    if (b % 2 == 0) return mystery(a+a, b/2);
 *    return mystery(a+a, b/2) + a;
 *  }
 *
 *  What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
 *  a and b, describe what value mystery(a, b) computes. Answer the same question, but
 *  replace + with * and replace return 0 with return 1
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_18 {
  public static void main(String[] args) {
    // mystery(a, b) computes a * b
    StdOut.println(mystery(2, 25)); // 2 + 16 + 32 = 50 (or 2 * 25)
    StdOut.println(mystery(3, 11)); // 3 + 6 + 24 = 33 (or 3 * 11)

    // mysteryB(a, b) computes a^b
    StdOut.println(mysteryB(2, 3)); // 2 * 4 = 8 (or 2^3)
    StdOut.println(mysteryB(3, 5)); // 3 * 81 = 247 (or 3^5)
  }

  public static int mystery(int a, int b) {
    if (b == 0) {
      return 0;
    }
    if (b % 2 == 0) {
      return mystery(a + a, b / 2);
    }
    return mystery(a + a, b / 2) + a;
  }

  public static int mysteryB(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 0) {
      return mysteryB(a * a, b / 2);
    }
    return mysteryB(a * a, b / 2) * a;
  }
}
