/* *****************************************************************************
 *  Exercise: 1.1.30
 *
 *  Description:
 *  ------------
 *  Array exercise. Write a code fragment that creates an N-by-N boolean array a[][] such that
 *  a[i][j] is true if i and j are relatively prime (have no common factors), and false otherwise
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_30 {
  public static void main(String[] args) {
    StdOut.print("Please provide an integer: ");
    int n = StdIn.readInt();
    StdOut.printf("Coprimeness matrix %d x %d:\n", n, n);
    StdArrayIO.print(getCoprimenessMatrix((n)));
  }

  private static boolean[][] getCoprimenessMatrix(int n) {
    boolean[][] array = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        // j >= i
        array[i][j] = areCoprime(j, i);
        array[j][i] = array[i][j];
      }
    }

    return array;
  }

  private static boolean areCoprime(int a, int b) {
    return (a != 0 || b != 0) && gcd(a, b) == 1;
  }

  private static int gcd(int p, int q) {
    if (p == 0 && q == 0) {
      throw new Error("gcd(0, 0) is not defined");
    }
    return q == 0 ? p : gcd(q, p % q);
  }
}
