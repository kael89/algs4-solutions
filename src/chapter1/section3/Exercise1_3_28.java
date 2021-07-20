/* *****************************************************************************
 *  Exercise: 1.3.27
 *
 *  Description:
 *  ------------
 *  Develop a recursive solution to the previous question.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_28 {
  public static void main(String[] args) {
    List<Integer> list = new List<Integer>(new Integer[]{5, 3, 2, 100, 1});
    runMax(list, new int[]{0, 1, 4});

    List<Integer> emptyList = new List<Integer>(new Integer[]{});
    runMax(emptyList, new int[]{});

    List<Integer> listWithZeroes = new List<Integer>(new Integer[]{0, 0, 0});
    runMax(listWithZeroes, new int[]{1, 2});
  }

  private static void printList(List<Integer> list) {
    StdOut.print("List: ");
    list.print();
    StdOut.println();
  }

  private static void runMax(List<Integer> list, int[] indexes) {
    StdOut.println();
    printList(list);
    StdOut.printf("Max: %d\n", max(list.first));
    for (int index : indexes) {
      StdOut.printf("Max (start at %d): %d\n", index, max(list.get(index)));
    }
  }

  private static int max(Node<Integer> first) {
    return max(first, 0);
  }

  private static int max(Node<Integer> first, int currentMax) {
    if (first == null) {
      return currentMax;
    }
    return max(first.next, first.item > currentMax ? first.item : currentMax);
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
