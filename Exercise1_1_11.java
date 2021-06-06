/* *****************************************************************************
 *  Exercise: 1.1.11
 *
 *  Description:
 *  ------------
 *  Write a code fragment that prints the contents of a two-dimensional boolean
 *  array, using * to represent true and a space to represent false. Include row and column
 *  numbers.
 *   **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_11 {
  private static boolean[][] booleans = {
          {true, false, false, true},
          {true, false, false, true},
          {false, false, false, true},
          {true, true, true, true},
          {false, false, false, false},
  };

  private static boolean[][] booleansLongRow = {
          {true, false, false, true, false, false, false, false, true, true},
  };

  private static boolean[][] booleansLongColumn = {
          {true},
          {true},
          {false},
          {true},
          {false},
          {false},
          {false},
          {false},
          {true},
          {true},
          {false},
          {true},
  };

  private static int countDigits(int a) {
    return String.valueOf(a).length();
  }

  public static void main(String[] args) {
    printBooleans(booleans);
    StdOut.println();

    printBooleans(booleansLongRow);
    StdOut.println();

    printBooleans(booleansLongColumn);
  }

  private static void printBooleans(boolean[][] booleans) {
    int rows = booleans.length;
    int cols = booleans[0].length;

    int rowWidth = countDigits(rows);

    // Add + 1 to leave enough space between columns
    int colWidth = countDigits(cols) + 1;

    printCell(' ', rowWidth);
    for (int i = 0; i < cols; i++) {
      printCell(i + 1, colWidth);
    }
    StdOut.println();

    for (int i = 0; i < rows; i++) {
      printCell(i + 1, rowWidth);
      for (int j = 0; j < cols; j++) {
        printCell(booleans[i][j] ? '*' : '-', colWidth);
      }
      StdOut.println();
    }
  }

  private static void printCell(int c, int width) {
    StdOut.printf("%" + width + "d", c);
  }

  private static void printCell(char c, int width) {
    StdOut.printf("%" + width + "c", c);
  }
}
