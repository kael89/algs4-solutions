/* *****************************************************************************
 *  Exercise: 2.1.18
 *
 *  Description:
 *  ------------
 *  Visual trace. Modify your solution to the previous exercise to make Insertion
 *  and Selection produce visual traces such as those depicted in this section.
 *  Hint : Judicious use of setYscale() makes this problem easy.
 *  Extra credit : Add the code necessary to produce red and gray color accents such
 *  as those in our figures.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.Color;

public class Exercise2_1_18 {
  private static final int CANVAS_SIZE = 800;

  private static final double LINE_MARGIN_PERCENT = 0.3;

  private static final double HORIZONTAL_MARGIN = 0.05;

  private static final double VERTICAL_MARGIN = 0.05;

  private static final int PRINT_INTERVAL = 100;

  public static void main(String[] args) {
    StdOut.print("n: ");
    int n = StdIn.readInt();

    Double[] selectionArray = ArrayHelpers.generateRandom(n);
    Double[] insertionArray = ArrayHelpers.generateRandom(n);

    StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
    StdDraw.enableDoubleBuffering();

    new Selection<Double>().sort(selectionArray);
    StdDraw.pause(3 * PRINT_INTERVAL);
    new Insertion<Double>().sort(insertionArray);

    StdDraw.disableDoubleBuffering();
  }

  private static void draw(Double[] array, int[] indexBoundaries, int min) {
    double width = (1.0 - 2 * HORIZONTAL_MARGIN) / array.length / 2.0;
    double x = HORIZONTAL_MARGIN;

    for (int i = 0; i < array.length; i++) {
      Color color = Color.GRAY;
      if (i == min) {
        color = Color.RED;
      } else if (inRange(i, indexBoundaries)) {
        color = Color.BLACK;
      }

      drawBar(x, width, array[i] * (1 - LINE_MARGIN_PERCENT), color);
      x += 2 * width;
    }

    StdDraw.show();
    StdDraw.pause(PRINT_INTERVAL);
  }

  private static boolean inRange(int x, int[] range) {
    return range[0] <= x && x <= range[1];
  }

  private static void drawBar(double x, double width, double height, Color color) {
    double maxHalfHeight = 0.5;
    double halfHeight = height / 2.0;

    // Use white color to erase any colors drawn in the bar's position in previous renders
    StdDraw.setPenColor(Color.WHITE);
    StdDraw.filledRectangle(x, maxHalfHeight, width / 2.0, maxHalfHeight);

    StdDraw.setPenColor(color);
    StdDraw.filledRectangle(x, halfHeight, width / 2.0, halfHeight);
  }

  private static void setYScale(int i, int n) {
    StdDraw.setYscale(-1 * (n - 1) + i - VERTICAL_MARGIN, i + 1 + VERTICAL_MARGIN);
  }

  static class Selection<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] a) {
      StdDraw.clear();

      int n = a.length;

      int[] indexBoundaries = new int[2];
      int i = 0;
      for (; i < n; i++) {
        setYScale(i, n);

        indexBoundaries[0] = i;
        int min = i;
        for (int j = i + 1; j < n; j++) {
          indexBoundaries[1] = j;
          if (less(a[j], a[min])) {
            min = j;
          }
          draw((Double[]) a, indexBoundaries, min);
        }

        exchange(a, i, min);
      }

      indexBoundaries[0] = n - 1;
      indexBoundaries[1] = n - 1;
      draw((Double[]) a, indexBoundaries, n - 1);
    }
  }

  static class Insertion<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] a) {
      StdDraw.clear();
      int n = a.length;
      if (n == 0) {
        return;
      }

      int[] indexBoundaries = new int[] { 0, 0 };
      setYScale(0, n);
      draw((Double[]) a, indexBoundaries, 0);

      for (int i = 1; i < n; i++) {
        setYScale(i, n);

        indexBoundaries[0] = i;
        indexBoundaries[1] = i;
        draw((Double[]) a, indexBoundaries, i);

        for (int j = i; j > 0; j--) {
          indexBoundaries[0] = j;

          if (!less(a[j], a[j - 1])) {
            break;
          } else {
            exchange(a, j, j - 1);
            draw((Double[]) a, indexBoundaries, j - 1);
          }
        }
      }
    }
  }
}
