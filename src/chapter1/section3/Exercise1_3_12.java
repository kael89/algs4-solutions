/* *****************************************************************************
 *  Exercise: 1.3.10
 *
 *  Description:
 *  ------------
 *  Write an iterable Stack client that has a static method copy() that takes a stack of strings as
 *  argument and returns a copy of the stack.
 *  Note: This ability is a prime example of the value of having an iterator, because it allows
 *  development of such functionality without changing the basic API.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise1_3_12 {
  public static void main(String[] args) {
    Stack<String> source = new Stack<String>();
    while (!StdIn.isEmpty()) {
      source.push(StdIn.readString());
    }
    Stack<String> clone = copy(source);

    StdOut.print("Original stack: ");
    print(source);
    StdOut.print("Copied stack: ");
    print(clone);
  }

  private static Stack<String> copy(Stack<String> source) {
    String[] array = new String[source.size()];

    Iterator<String> sourceIt = source.iterator();
    for (int i = 0; i < array.length; i++) {
      array[i] = sourceIt.next();
    }

    Stack<String> clone = new Stack<String>();
    for (int i = array.length - 1; i >= 0; i--) {
      clone.push(array[i]);
    }
    return clone;
  }

  private static void print(Stack<String> stack) {
    for (String item : stack) {
      StdOut.print(item + " ");
    }
    System.out.println();
  }
}
