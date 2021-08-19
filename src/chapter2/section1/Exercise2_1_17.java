/* *****************************************************************************
 *  Exercise: 2.1.17
 *
 *  Description:
 *  ------------
 *  Animation. Add code to Insertion and Selection to make them draw the
 *  array contents as vertical bars like the visual traces in this section, redrawing the bars
 *  after each pass, to produce an animated effect, ending in a “sorted” picture where the
 *  bars appear in order of their height. Hint : Use a client like the one in the text that
 *  generates random Double values, insert calls to show() as appropriate in the sort code, and
 *  implement a show() method that clears the canvas and draws the bars
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2_1_17 {
  private static final int CANVAS_SIZE = 800;

  private static final double TOP_MARGIN = 0.05;

  private static final double HORIZONTAL_MARGIN = 0.03;

  private static final int PRINT_INTERVAL = 100;

  public static void main(String[] args) {
    StdOut.print("n: ");
    int n = StdIn.readInt();

    Double[] selectionArray = ArrayHelpers.generateRandom(n);
    Double[] insertionArray = ArrayHelpers.generateRandom(n);

    StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
    StdDraw.enableDoubleBuffering();
    StdDraw.setYscale(0, 1.0 + TOP_MARGIN);

    new Selection<Double>().sort(selectionArray);
    StdDraw.pause(3 * PRINT_INTERVAL);
    new Insertion<Double>().sort(insertionArray);

    StdDraw.disableDoubleBuffering();
  }

  private static void draw(Double[] array) {
    double barHalfWidth = (1.0 - 2 * HORIZONTAL_MARGIN) / array.length / 4.0;

    StdDraw.clear();
    double x = HORIZONTAL_MARGIN + barHalfWidth;
    for (int i = 0; i < array.length; i++) {
      double barHalfHeight = array[i] / 2;
      StdDraw.filledRectangle(x, barHalfHeight, barHalfWidth, barHalfHeight);
      // move 2 times to the right for the bar, plus the same amount for the gap
      x += 4 * barHalfWidth;
    }
    StdDraw.show();
    StdDraw.pause(PRINT_INTERVAL);
  }

  static class Selection<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] a) {
      int n = a.length;

      for (int i = 0; i < n; i++) {
        int min = i;
        for (int j = i + 1; j < n; j++)
          if (less(a[j], a[min])) {
            min = j;
          }
        exchange(a, i, min);
        draw((Double[]) a);
      }
    }
  }

  static class Insertion<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] a) {
      int n = a.length;
      for (int i = 1; i < n; i++) {
        for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
          exchange(a, j, j - 1);
        }
        draw((Double[]) a);
      }
    }
  }
}
