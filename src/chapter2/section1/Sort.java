package chapter2.section1;

public class Sort<T extends Comparable<T>> {
  protected boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  protected void exchange(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
