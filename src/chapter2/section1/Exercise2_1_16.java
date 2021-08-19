/* *****************************************************************************
 *  Exercise: 2.1.16
 *
 *  Description:
 *  ------------
 *  Certification. Write a check() method that calls sort() for a given array and
 *  returns true if sort() puts the array in order and leaves the same set of objects in the
 *  array as were there initially, false otherwise. Do not assume that sort() is restricted to
 *  move data only with exch(). You may use Arrays.sort() and assume that it is correct.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise2_1_16 {
  public static void main(String[] args) {
//    StdOut.println("Please provide a list of integers: ");
    Integer[] array = toIntegers(StdIn.readAllInts());

    TestSort<Integer> testSort = new TestSort<Integer>();
    ArrayHelpers.print(array);
    StdOut.println("Was sorted correctly: " + testSort.check(array));
  }

  public static Integer[] toIntegers(int[] array) {
    Integer[] result = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
    return result;
  }

  public static class TestSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] array) {
      Arrays.sort(array);
    }
  }
}
