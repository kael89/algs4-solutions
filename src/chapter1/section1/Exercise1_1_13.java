/* *****************************************************************************
 *  Exercise: 1.1.13
 *
 *  Description:
 *  ------------
 *  Write a code fragment to print the transposition (rows and columns changed)
 *  of a two-dimensional array with M rows and N columns.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdArrayIO;

public class Exercise1_1_13 {
  private static final int N = 3;

  private static final int M = 4;

  public static void main(String[] args) {
    int[][] array = new int[N][M];

    initializeArray(array);
    StdArrayIO.print(array);
    StdArrayIO.print(transposeArray(array));
  }

  private static void initializeArray(int[][] array) {
    int counter = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        array[i][j] = counter++;
      }
    }
  }

  private static int[][] transposeArray(int[][] array) {
    int[][] transposedArray = new int[M][N];

    for (int j = 0; j < M; j++) {
      for (int i = 0; i < N; i++) {
        transposedArray[j][i] = array[i][j];
      }
    }

    return transposedArray;
  }
}
