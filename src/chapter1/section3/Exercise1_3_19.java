/* *****************************************************************************
 *  Exercise: 1.3.19
 *
 *  Description:
 *  ------------
 *  Give a code fragment that removes the last node in a linked list whose first node is first.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_19 {
  public static void main(String[] args) {
    List<Integer> list = readList();

    StdOut.print("Before: ");
    list.print();
    StdOut.println();

    list.deleteLast();
    StdOut.print("After: ");
    list.print();
    StdOut.println();
  }

  private static List<Integer> readList() {
    List<Integer> list = new List<Integer>();
    for (int x : StdIn.readAllInts()) {
      list.add(x);
    }

    return list;
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

    public Item deleteLast() {
      if (first == null) {
        // List is empty
        return null;
      }

      if (first.next == null) {
        // List contains a single item
        Item item = first.item;
        first = null;
        return item;
      }

      Node<Item> current = first;
      while (current.next != null && current.next.next != null) {
        current = current.next;
      }

      Item item = current.item;
      current.next = null;
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
