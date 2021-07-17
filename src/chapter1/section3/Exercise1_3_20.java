/* *****************************************************************************
 *  Exercise: 1.3.20
 *
 *  Description:
 *  ------------
 *  Write a method delete() that takes an int argument k and deletes the kth element
 * in a linked list, if it exists
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_20 {
  public static void main(String[] args) {
    String[] words = new In(args[0]).readAllStrings();
    List<String> list = new List<String>(words);

    StdOut.print("Initial: ");
    list.print();
    StdOut.println();

    Integer index = readNextIndex();
    while (index != null) {
      String deleted = list.delete(index);
      StdOut.println("Deleted: " + deleted);
      StdOut.print("After: ");
      list.print();
      StdOut.println();

      index = readNextIndex();
    }
  }

  private static Integer readNextIndex() {
    StdOut.print("Index to delete: ");
    String line = StdIn.readLine();
    if (line == null) {
      StdOut.println();
      return null;
    }

    return Integer.parseInt(line);
  }

  private static class Node<Item> {
    Item item;

    Node<Item> next;

    Node(Item item) {
      this.item = item;
      this.next = null;
    }
  }

  private static class List<Item> {
    Node<Item> first;

    Node<Item> current;

    int n = 0;

    List(Item[] items) {
      for (Item item : items) {
        add(item);
      }
    }

    public Item delete(int k) {
      if (first == null || k >= n) {
        throw new IllegalArgumentException("Index " + k + " does not exist in the list");
      }

      Node<Item> previous = first;
      for (int i = 1; i <= k - 1; i++) {
        previous = previous.next;
      }

      Item item;
      if (k == 0) {
        item = first.item;
        first = first.next;
      } else {
        item = previous.next.item;
        previous.next = previous.next.next;
      }

      n--;
      return item;
    }

    public void add(Item item) {
      Node<Item> node = new Node<Item>(item);

      if (current == null) {
        first = node;
        current = first;
      } else {
        current.next = node;
        current = node;
      }

      n++;
    }

    public void print() {
      Node<Item> temp = first;
      while (temp != null) {
        StdOut.print(temp.item + " ");
        temp = temp.next;
      }
    }
  }
}
