package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayHelpers {
  public static Double[] generateRandom(int n) {
    Double[] a = new Double[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(0.0, 1.0);
    }

    return a;
  }

  public static Double[] copy(Double[] array) {
    Double[] copy = new Double[array.length];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }

    return copy;
  }

  public static Integer[] copy(Integer[] array) {
    Integer[] copy = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }

    return copy;
  }

  public static void print(Integer[] array) {
    for (int i = 0; i < array.length; i++) {
      StdOut.print(array[i] + " ");
    }
    StdOut.println();
  }

  public static void print(Double[] array) {
    if (array.length == 0) {
      StdOut.println();
      return;
    }

    for (int i = 0; i < array.length - 1; i++) {
      StdOut.print(array[i] + ", ");
    }
    StdOut.print(array[array.length - 1]);
    StdOut.println();
  }
}
