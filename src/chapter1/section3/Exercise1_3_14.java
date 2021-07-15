/* *****************************************************************************
 *  Exercise: 1.3.14
 *
 *  Description:
 *  ------------
 *  Develop a class ResizingArrayQueueOfStrings that implements the queue abstraction
 *  with a fixed-size array, and then extend your implementation to use array resizing
 *  to remove the size restriction.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise1_3_14 {
  public static void main(String[] args) {
    ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("-")) {
        StdOut.println(queue.dequeue());
      } else {
        queue.enqueue(s);
      }
    }

    StdOut.print("\nIterating over queue: ");
    for (String s : queue) {
      StdOut.print(s + " ");
    }
    StdOut.println();

    queue.printArrayStats();
  }

  private static class ResizingArrayQueue<Item> implements Iterable<Item> {
    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];

    private int n = 0; // number of items

    private int front = 0;

    private int back = n;

    public boolean isEmpty() {
      return n == 0;
    }

    public int size() {
      return n;
    }

    private double lg(int n) {
      return Math.log(n) / Math.log(2);
    }

    private void resize(int maxInput) {
      // Round maxInput up to the closest power of 2
      // Example of input that would result in maxInput not being a power of 2:
      // 1 2 3 4 - 5
      int max = (int) Math.pow(2, Math.ceil(lg(maxInput)));
      StdOut.printf("MaxInput: %d, max: %d\n", maxInput, max);

      @SuppressWarnings("unchecked") Item[] temp = (Item[]) new Object[max];
      int i = 0;
      for (int j = front; j < front + n; j++) {
        temp[i++] = a[j % a.length];
      }
      a = temp;
      front = 0;
      back = n;
    }

    public void enqueue(Item item) {
      if (n == a.length) {
        resize(2 * (n > 0 ? n : 1));
      }
      a[back++] = item;
      if (back == a.length) {
        back = 0; // Insert new elements at the start of the array (rotating index)
      }
      n++;
    }

    public Item dequeue() {
      Item item = a[front];
      a[front++] = null;
      n--;
      if (n > 0 && n == a.length / 4) {
        resize(a.length / 2);
      }
      if (front == a.length) {
        front = 0;
      }

      return item;
    }

    public void printArrayStats() {
      StdOut.println("Array size: " + a.length);
      StdOut.print("Contents: ");
      for (int i = 0; i < a.length; i++) {
        StdOut.print(a[i] + " ");
      }
      StdOut.println();
    }

    public Iterator<Item> iterator() {
      return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
      private int i = front;

      public boolean hasNext() {
        return i < n;
      }

      public Item next() {
        Item item = a[(front + i) % a.length];
        i++;
        return item;
      }
    }
  }
}
