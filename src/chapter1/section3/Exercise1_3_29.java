/* *****************************************************************************
 *  Exercise: 1.3.29
 *
 *  Description:
 *  ------------
 *  Write a Queue implementation that uses a circular linkedlist, which is the same
 *  as a linked list except that no links are null and the value of last.next is first whenever
 *  the list is not empty. Keep only one Node instance variable (last).
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_29 {
  public static void main(String[] args) {
    CircularListQueue<String> queue = new CircularListQueue<String>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      if (s.equals("-")) {
        StdOut.println("Dequeued: " + queue.dequeue());
        printQueue(queue);
      } else {
        queue.enqueue(s);
        printQueue(queue);
      }
    }
  }

  private static void printQueue(CircularListQueue<String> queue) {
    StdOut.print("Queue: ");
    queue.print();
    StdOut.println();
  }

  private static class Node<Item> {
    Item item;

    Node<Item> next;

    Node(Item item) {
      this.item = item;
      this.next = null;
    }
  }

  public static class CircularListQueue<Item> {
    Node<Item> last;

    private int n;

    public boolean isEmpty() {
      return last == null;
    }

    public int size() {
      return n;
    }

    public void enqueue(Item item) {
      Node<Item> newNode = new Node<Item>(item);
      if (last == null) {
        // List has a single item, make it self-referencing
        newNode.next = newNode;
      } else {
        newNode.next = last.next;
        last.next = newNode;
      }
      last = newNode;

      n++;
    }

    public Item dequeue() {
      if (isEmpty()) {
        throw new IllegalArgumentException("Queue underflow");
      }

      Node<Item> first = last.next;
      if (size() > 1) {
        last.next = first.next;
      } else {
        last = null;
      }

      n--;
      return first.item;
    }

    public void print() {
      if (isEmpty()) {
        return;
      }

      Node<Item> current = last.next;
      do {
        StdOut.print(current.item + " ");
        current = current.next;
      } while (!current.equals(last.next));
    }
  }
}
