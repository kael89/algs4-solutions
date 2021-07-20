/* *****************************************************************************
 *  Exercise: 1.3.24
 *
 *  Description:
 *  ------------
 *  Write a method removeAfter() that takes a linked-list Node as argument
 *  and removes the node following the given one (and does nothing if the argument
 * or the next field in the argument node is null).
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_24 {
  public static void main(String[] args) {
    List<String> list = new List<String>(new String[]{"alpha", "beta", "gamma", "delta"});
    printList(list);

    runRemoveAfter(list, 1);
    runRemoveAfter(list, 2);
    runRemoveAfter(list, 0);
  }

  private static void runRemoveAfter(List<String> list, int index) {
    Node<String> base = list.get(index);
    StdOut.println();
    StdOut.println("Removing node after " + base.item + "...");
    StdOut.println("Removed: " + removeAfter(base));
    printList(list);
  }

  private static void printList(List<String> list) {
    StdOut.print("List: ");
    list.print();
    StdOut.println();
  }

  private static String removeAfter(Node<String> node) {
    if (node == null || node.next == null) {
      return null;
    }

    String removedItem = node.next.item;
    node.next = node.next.next;
    return removedItem;
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
