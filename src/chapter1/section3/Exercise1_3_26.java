/* *****************************************************************************
 *  Exercise: 1.3.26
 *
 *  Description:
 *  ------------
 *  Write a method remove() that takes a linked list and a string key as arguments
 *  and removes all of the nodes in the list that have key as its item field.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_26 {
  public static void main(String[] args) {
    List<String> list = new List<String>(new String[]{"a", "a", "b", "d", "c", "c", "f"});
    printList(list);

    runRemove(list, "a");
    runRemove(list, "f");
    runRemove(list, "b");
    runRemove(list, "random");
    runRemove(list, "c");
  }

  private static void runRemove(List<String> list, String item) {
    StdOut.println();
    StdOut.printf("Removed %d items with key \"%s\"\n", remove(list, item), item);
    printList(list);
  }

  private static void printList(List<String> list) {
    StdOut.print("List: ");
    list.print();
    StdOut.println();
  }

  private static int remove(List<String> list, String item) {
    int count = 0;

    // Delete first items if matching the search item
    while (list.first != null && list.first.item.equals(item)) {
      list.first = list.first.next;
      count++;
    }

    if (list.first == null) {
      // List is empty
      return count;
    }

    Node<String> previous = list.first;
    while (previous.next != null) {
      if (previous.next.item.equals(item)) {
        // Delete non first item
        previous.next = previous.next.next;
        count++;
      }
    }

    return count;
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

    List(Item[] items) {
      for (Item item : items) {
        add(item);
      }
    }

    public Node<Item> get(int k) {
      if (k < 0) {
        throw new Error("Index must be >= 0");
      }
      if (first == null) {
        throw new IllegalArgumentException("List is empty");
      }

      current = first;
      for (int i = 1; i <= k; i++) {
        if (current == null) {
          throw new IllegalArgumentException("Index " + k + " does not exist in the list");
        }
        current = current.next;
      }

      return current;
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
