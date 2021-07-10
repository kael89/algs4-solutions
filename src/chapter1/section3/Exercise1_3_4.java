/* *****************************************************************************
 *  Exercise: 1.3.4
 *
 *  Description:
 *  ------------
 *  Write a stack client Parentheses that reads in a text stream from standard input
 *  and uses a stack to determine whether its parentheses are properly balanced.
 *  For example, your program should print true for [()]{}{[()()]()} and false for [(])
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Exercise1_3_4 {
  private static Stack<Character> stack = new Stack<Character>();

  public static void main(String[] args) {

    boolean isValid = true;
    while (!StdIn.isEmpty()) {
      char c = StdIn.readChar();
      isValid = parseCharacter(c);
      if (!isValid) {
        break;
      }
    }

    StdOut.println(isValid);
  }

  private static boolean parseCharacter(char c) {
    Parenthesis.Type type = Parenthesis.getType(c);

    if (type == Parenthesis.Type.LEFT) {
      stack.push(c);
    } else if (type == Parenthesis.Type.RIGHT) {
      char top = stack.pop();
      if (!Parenthesis.isPair(c, top)) {
        return false;
      }
    } else {
      throw new Error("Character is not a parenthesis: " + c);
    }

    return true;
  }

  private static class Parenthesis {

    private static ArrayList<Character> leftChars = new ArrayList<Character>() {
      {
        add('(');
        add('{');
        add('[');
      }
    };

    private static ArrayList<Character> rightChars = new ArrayList<Character>() {
      {
        add(')');
        add('}');
        add(']');
      }
    };

    public static Type getType(char c) {
      if (leftChars.contains(c)) {
        return Type.LEFT;
      }
      if (rightChars.contains(c)) {
        return Type.RIGHT;
      }
      return null;
    }

    private static boolean isPair(char a, char b) {
      // Left parentheses have a lower char code than right ones
      char left = (char) Math.min(a, b);
      char right = (char) Math.max(a, b);

      int leftIndex = leftChars.indexOf(left);
      int rightIndex = rightChars.indexOf(right);
      return leftIndex != -1 && leftIndex == rightIndex;
    }

    private enum Type {
      LEFT, RIGHT
    }
  }
}
