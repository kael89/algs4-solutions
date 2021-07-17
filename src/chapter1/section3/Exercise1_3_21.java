/* *****************************************************************************
 *  Exercise: 1.3.21
 *
 *  Description:
 *  ------------
 *  Write a method find() that takes a linked list and a string key as arguments
 *  and returns true if some node in the list has key as its item field, false otherwise.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_21 {
  public static void main(String[] args) {
    String[] words = new In(args[0]).readAllStrings();
    List<String> list = new List<String>(words);

    StdOut.print("List: ");
    list.print();
    StdOut.println();

    String key = StdIn.readLine();
    while (key != null) {
      StdOut.println("Found: " + list.find(key));

      key = StdIn.readLine();
    }
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

    public boolean find(Item item) {
      Node<Item> current = first;
      while (current != null) {
        if (current.item.equals(item)) {
          return true;
        }
        current = current.next;
      }

      return false;
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
