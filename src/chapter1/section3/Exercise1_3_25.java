/* *****************************************************************************
 *  Exercise: 1.3.25
 *
 *  Description:
 *  ------------
 *  Write a method insertAfter() that takes two linked-list Node argument sand inserts the second
 * after the first on its list (and does nothing if either argument is null).
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_25 {
  public static void main(String[] args) {
    List<String> list = new List<String>(new String[]{"alpha", "beta", "gamma", "delta"});
    printList(list);

    runInsertAfter(list, 0, "alpha2");
    runInsertAfter(list, 1, "alpha3");
    runInsertAfter(list, 0, "alpha1.5");
    runInsertAfter(list, 6, "delta2");
  }

  private static void runInsertAfter(List<String> list, int index, String newItem) {
    Node<String> baseNode = list.get(index);
    StdOut.println();
    StdOut.printf("Inserting \"%s\" after \"%s\"...\n", newItem, baseNode.item);
    insertAfter(baseNode, new Node<String>(newItem));
    printList(list);
  }

  private static void printList(List<String> list) {
    StdOut.print("List: ");
    list.print();
    StdOut.println();
  }

  private static void insertAfter(Node<String> baseNode, Node<String> newNode) {
    if (baseNode == null || newNode == null) {
      return;
    }

    newNode.next = baseNode.next;
    baseNode.next = newNode;
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
