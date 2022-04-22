/* *****************************************************************************
 *  Exercise: 1.3.2
 *
 *  Description:
 *  ------------
 *  Give the output printed by java Stack for the input
 *  it was - the best - of times - - - it  was - the - -
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_2 {
  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
    }
    // Prints: was best times of the was the it

    StdOut.println("(" + s.size() + " left on stack)");
  }
}
