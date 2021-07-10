/* *****************************************************************************
 *  Exercise: 1.3.6
 *
 *  Description:
 *  ------------
 *  What does the following code fragment do to the queue q?
 *
 *  Stack<String> stack = new Stack<String>();
 *  while (!q.isEmpty())
 *    stack.push(q.dequeue());
 *  while (!stack.isEmpty())
 *    q.enqueue(stack.pop());
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_6 {
  public static void main(String[] args) {
    // Answer: it reverses the queue

    Queue<String> q = readQueue();
    runFragment(q);
    StdOut.println(q);
  }

  private static Queue<String> readQueue() {
    Queue<String> q = new Queue<String>();

    StdOut.println("Please give a list of strings: ");
    while (!StdIn.isEmpty()) {
      q.enqueue(StdIn.readString());
    }

    return q;
  }

  private static void runFragment(Queue<String> q) {
    Stack<String> stack = new Stack<String>();
    while (!q.isEmpty()) {
      stack.push(q.dequeue());
    }
    while (!stack.isEmpty()) {
      q.enqueue(stack.pop());
    }
  }
}
