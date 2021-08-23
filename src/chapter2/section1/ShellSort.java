package chapter2.section1;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
  public void sort(T[] a) {
    int n = a.length;
    int h = 1;
    while (h < n / 3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
          exchange(a, j, j - h);
      }
      h = h / 3;
    }
  }
}
