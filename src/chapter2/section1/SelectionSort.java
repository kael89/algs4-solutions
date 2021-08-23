package chapter2.section1;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
  public void sort(T[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++)
        if (less(a[j], a[min])) {
          min = j;
        }
      exchange(a, i, min);
    }
  }
}
