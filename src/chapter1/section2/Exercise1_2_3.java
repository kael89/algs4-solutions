/* *****************************************************************************
 *  Exercise: 1.2.3
 *
 *  Description:
 *  ------------
 *  Write an Interval2D client that takes command-line arguments N, min, and max
 *  and generates N random 2D intervals whose width and height are uniformly distributed
 *  between min and max in the unit square. Draw them on StdDraw and print the number
 *  of pairs of intervals that intersect and the number of intervals that are contained in one
 *  another.
 **************************************************************************** */

package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_3 {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double min = Double.parseDouble(args[1]);
    double max = Double.parseDouble(args[2]);

    Box[] boxes = new Box[n];
    for (int i = 0; i < n; i++) {
      boxes[i] = Box.createRandom(min, max);
      boxes[i].draw();
    }

    StdOut.println("Number of intersecting pairs: " + getIntersectionCount(boxes));
    StdOut.println("Number of included pairs: " + getSubsetCount(boxes));
  }

  private static int getIntersectionCount(Box[] boxes) {
    int count = 0;

    for (int i = 0; i < boxes.length; i++) {
      for (int j = i + 1; j < boxes.length; j++) {
        if (boxes[i].intersects(boxes[j])) {
          count++;
        }
      }
    }

    return count;
  }

  private static int getSubsetCount(Box[] boxes) {
    int count = 0;

    for (int i = 0; i < boxes.length; i++) {
      for (int j = i + 1; j < boxes.length; j++) {
        if (boxes[i].contains(boxes[j]) || boxes[j].contains(boxes[i])) {
          count++;
        }
      }
    }

    return count;
  }

  private static class Box {
    private static final double CANVAS_SIZE = 1.0;

    private final Interval1D width;

    private final Interval1D height;

    private final Interval2D interval2D;

    public Box(Interval1D width, Interval1D height) {
      this.width = width;
      this.height = height;
      this.interval2D = new Interval2D(width, height);
    }

    public static Box createRandom(double min, double max) {
      return new Box(createRandomInterval1D(min, max), createRandomInterval1D(min, max));
    }

    private static Interval1D createRandomInterval1D(double min, double max) {
      double left = StdRandom.uniform(0, CANVAS_SIZE);
      double delta = StdRandom.uniform(min, max);
      double right = left + delta;

      return right < CANVAS_SIZE ? new Interval1D(left, right) : new Interval1D(left - delta, left);
    }

    public Point2D[] getPoints() {
      return new Point2D[]{
          new Point2D(this.width.min(), this.height.max()),
          new Point2D(this.width.max(), this.height.max()),
          new Point2D(this.width.max(), this.height.min()),
          new Point2D(this.width.min(), this.height.min()),
      };
    }

    public void draw() {
      this.interval2D.draw();
    }

    public boolean contains(Box box) {
      for (Point2D point : box.getPoints()) {
        if (!contains(point)) {
          return false;
        }
      }

      return true;
    }

    public boolean contains(Point2D point) {
      return this.interval2D.contains(point);
    }

    public boolean intersects(Box target) {
      return this.interval2D.intersects(target.getInterval2D());
    }

    protected Interval2D getInterval2D() {
      return this.interval2D;
    }
  }
}
