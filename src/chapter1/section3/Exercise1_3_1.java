/* *****************************************************************************
 *  Exercise: 1.3.1
 *
 *  Description:
 *  ------------
 *  Add a method isFull() to FixedCapacityStackOfStrings.
 **************************************************************************** */

package chapter1.section3;

public class Exercise1_3_1 {
  public static void main(String[] args) {
    FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(2);
    s.push("a");
    System.out.println(s.isFull()); // false
    s.push("b");
    System.out.println(s.isFull()); // true
  }

  private static class FixedCapacityStackOfStrings {
    private String[] a;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
      a = new String[cap];
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public boolean isFull() {
      return size() == a.length;
    }

    public int size() {
      return N;
    }

    public void push(String item) {
      a[N++] = item;
    }

    public String pop() {
      return a[--N];
    }
  }
}
