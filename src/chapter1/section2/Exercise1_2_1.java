/* *****************************************************************************
 *  Exercise: 1.2.1
 *
 *  Description:
 *  ------------
 *  Write a Point2D client that takes an integer value N from the command line,
 *  generates N random points in the unit square, and computes the distance separating
 *  the closest pair of points
 **************************************************************************** */

package chapter1.section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_1 {
  private static final double PEN_RADIUS = 0.01;

  public static void main(String[] args) {
    StdOut.print("N: ");
    int n = StdIn.readInt();
    Point2D[] points = new Point2D[n];

    StdDraw.setPenRadius(PEN_RADIUS);
    for (int i = 0; i < n; i++) {
      points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
      points[i].draw();
    }
    StdOut.println("Minimum distance: " + getMinDistance(points));
  }

  private static double getMinDistance(Point2D[] points) {
    double minDistance = Double.POSITIVE_INFINITY;

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double distance = points[i].distanceTo(points[j]);
        if (distance < minDistance) {
          minDistance = distance;
        }
      }
    }

    return minDistance;
  }
}
