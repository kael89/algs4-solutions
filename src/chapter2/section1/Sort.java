package chapter2.section1;

import java.util.Arrays;

public abstract class Sort<T extends Comparable<T>> {
  public abstract void sort(T[] array);

  protected boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  protected void exchange(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  @SuppressWarnings("unchecked")
  public boolean check(Integer[] input) {
    Integer[] expected = ArrayHelpers.copy(input);
    Arrays.sort(expected);

    Integer[] received = ArrayHelpers.copy(input);
    sort((T[]) received);

    if (received.length != expected.length) {
      return false;
    }

    for (int i = 0; i < expected.length; i++) {
      if (received[i] != expected[i]) {
        return false;
      }
    }

    return true;
  }
}
