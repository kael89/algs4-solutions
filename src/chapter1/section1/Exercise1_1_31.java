/* *****************************************************************************
 *  Exercise: 1.1.31
 *
 *  Description:
 *  ------------
 *  Random connections. Write a program that takes as command-line arguments an integer N and
 *  a double value p (between 0 and 1), plots N equally spaced dots of size .05
 *  on the circumference of a circle, and then, with probability p for each pair of points,
 *  draws a gray line connecting them.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Exercise1_1_31 {
  private static final double[] CENTER = new double[]{ 0.5, 0.5 };

  private static final double RADIUS = 0.3;

  private static final double PEN_RADIUS_CIRCLE = 0.02;

  private static final double PEN_RADIUS_LINE = 0.005;

  private static final Color PEN_COLOR_CIRCLE = Color.BLACK;

  private static final Color PEN_COLOR_LINE = Color.GRAY;

  public static void main(String[] args) {
    StdOut.print("N: ");
    final int n = StdIn.readInt();
    StdOut.print("p [0-1]: ");
    double p = StdIn.readDouble();
    if (p < 0 || p > 1) {
      throw new Error("p must be between 0 and 1");
    }

    draw(n, p);
  }

  private static void draw(int n, double p) {

    double theta = 2 * Math.PI / n;
    double chordLength = getChordLength(theta);
    double totalLength = chordLength * n;

    double[] point = new double[]{ 0, RADIUS };
    for (int i = 0; i < n; i++) {
      drawCirclePoint(point);

      double[] oldPoint = clonePoint(point);
      point = getNextPointClockwise(point, i, chordLength, totalLength);
      if (StdRandom.uniform() < p) {
        drawCircleChord(oldPoint, point);
      }
    }
  }

  private static double[] clonePoint(double[] point) {
    return new double[]{ point[0], point[1] };
  }

  private static void drawCirclePoint(double[] point) {
    StdDraw.setPenRadius(PEN_RADIUS_CIRCLE);
    StdDraw.setPenColor(PEN_COLOR_CIRCLE);
    StdDraw.point(CENTER[0] + point[0], CENTER[1] + point[1]);
  }

  private static void drawCircleChord(double[] pointA, double[] pointB) {
    StdDraw.setPenRadius(PEN_RADIUS_LINE);
    StdDraw.setPenColor(PEN_COLOR_LINE);
    StdDraw.line(CENTER[0] + pointA[0], CENTER[1] + pointA[1], CENTER[0] + pointB[0], CENTER[1] + pointB[1]);
  }

  private static double[] getNextPointClockwise(double[] point, int pointId, double chordLength, double totalLength) {
    int nextQuarter = getQuarter(pointId + 1, chordLength, totalLength);
    double x = getNextXClockwise(point, chordLength);
    double y = getNextYClockWise(x, nextQuarter);

    return new double[]{ x, y };
  }

  private static int getQuarter(int pointId, double chordLength, double totalLength) {
    return (int) (4 * (pointId) * chordLength / totalLength) % 4;
  }

  private static double getNextXClockwise(double[] point, double chordLength) {
    int currentQuarter = getQuarter(point);
    double[] xValues = calculateAdjacentXValues(point, chordLength);
    return currentQuarter == 0 || currentQuarter == 3 ? max(xValues) : min(xValues);
  }

  private static double getNextYClockWise(double x, double nextQuarter) {
    int ySign = nextQuarter == 0 || nextQuarter == 3 ? 1 : -1;
    return ySign * Math.sqrt(pow2(RADIUS) - pow2(x));
  }

  private static double max(double[] array) {
    double max = Double.NEGATIVE_INFINITY;
    for (double item : array) {
      if (item > max) {
        max = item;
      }
    }

    return max;
  }

  private static double min(double[] array) {
    double min = Double.POSITIVE_INFINITY;
    for (double item : array) {
      if (item < min) {
        min = item;
      }
    }

    return min;
  }

  private static int getQuarter(double[] point) {
    double x = point[0];
    double y = point[1];

    if (x >= 0) {
      return y > 0 ? 0 : 1;
    }
    return y > 0 ? 3 : 2;
  }

  /**
   * Problem definition
   *
   * Known
   * -----
   * r: radius of the circle
   * (x0, y0): current point
   * d: chord length
   *
   * Unknown
   * -------
   * (x, y): next point
   *
   * Equations
   * ---------
   * // and y are points in a circle with radius r:
   * x^2 + y^ = r^2
   * // the distance between (x0, y0) and (x, y) equals the chord length:
   * (x - x0)^2 + (y - y0)^2 = d^2
   *
   * Solving the above equations for x:
   * * y0 = 0 => x = (x0^2 + r^2 - d^2) / (2 * x0)
   * * y0 != 0 => (1 + x0^2 / y0^2) * x^2 - (2 * k * x0 / y0) * x + k^2 - r^2 = 0
   * where k: (x^0 + y0^2 + r^2 - d^2) / 2 * y0
   */
  private static double[] calculateAdjacentXValues(double[] startPoint, double chordLength) {
    double r = RADIUS;
    double x0 = startPoint[0];
    double y0 = startPoint[1];
    double d = chordLength;

    if (y0 == 0) {
      return new double[]{ (pow2(x0) + pow2(r) - pow2(d)) / (2 * x0) };
    }

    double k = (pow2(x0) + pow2(y0) + pow2(r) - pow2(d)) / (2 * y0);
    double a = 1 + pow2(x0) / pow2(y0);
    double b = -2 * k * x0 / y0;
    double c = pow2(k) - pow2(r);
    // The two solutions for x indicate that the "next" x could be either in
    // clockwise or anti-clockwise direction
    return calculateQuadratic(a, b, c);
  }

  private static double pow2(double a) {
    return Math.pow(a, 2);
  }

  /**
   * @param theta The angle of the chord in radians
   */
  private static double getChordLength(double theta) {
    return getHypotenuse(Math.sin(theta) * RADIUS, RADIUS - Math.cos(theta) * RADIUS);
  }

  private static double getHypotenuse(double a, double b) {
    return Math.sqrt(pow2(a) + pow2(b));
  }

  private static double[] calculateQuadratic(double a, double b, double c) {
    double d = pow2(b) - 4 * a * c;
    double x1 = -1 * (b - Math.sqrt(d)) / (2 * a);
    double x2 = -1 * (b + Math.sqrt(d)) / (2 * a);

    return new double[]{ x1, x2 };
  }
}
