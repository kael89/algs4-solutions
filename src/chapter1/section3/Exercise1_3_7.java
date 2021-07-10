/* *****************************************************************************
 *  Exercise: 1.3.7
 *
 *  Description:
 *  ------------
 *  Add a method peek() to Stack that returns the most recently inserted item on
 *  the stack (without popping it).
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_7 {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    while (!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }

    StdOut.println("Peek: " + stack.peek());
    StdOut.println("Pop: " + stack.pop());
  }

  private static class Stack<Item> {
    private Node first; // top of stack (most recently added node)

    private int N; // number of items

    public boolean isEmpty() {
      return first == null;
    } // Or: N == 0.

    public int size() {
      return N;
    }

    public void push(Item item) {
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
      N++;
    }

    public Item pop() {
      Item item = first.item;
      first = first.next;
      N--;
      return item;
    }

    public Item peek() {
      return first.item;
    }

    private class Node {
      Item item;

      Node next;
    }
  }
}
