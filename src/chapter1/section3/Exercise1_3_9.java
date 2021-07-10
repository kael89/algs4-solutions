/* *****************************************************************************
 *  Exercise: 1.3.9
 *
 *  Description:
 *  ------------
 *  Write a program that takes from standard input an expression without left parentheses
 *  and prints the equivalent infix expression with the parentheses inserted.
 *  For  example, given the input:
 *    1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 *  your program should print
 *    ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_9 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String c = StdIn.readString();
      if (c.equals(")")) {
        String rightOperand = stack.pop();
        String operator = stack.pop();
        String leftOperand = stack.pop();
        stack.push("( " + leftOperand + " " + operator + " " + rightOperand + " )");
      } else {
        stack.push(c);
      }
    }

    StdOut.println(stack.pop());
  }
}
