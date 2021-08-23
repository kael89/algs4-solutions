package chapter2.section1;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
  public void sort(T[] a) {
    int n = a.length;
    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exchange(a, j, j - 1);
      }
    }
  }
}
