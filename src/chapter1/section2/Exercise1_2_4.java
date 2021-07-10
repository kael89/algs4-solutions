/* *****************************************************************************
 *  Exercise: 1.2.4
 *
 *  Description:
 *  ------------
 *  What does the following code fragment print?
 *
 *  String string1 = "hello";
 *  String string2 = string1;
 *  string1 = "world";
 *  StdOut.println(string1);
 *  StdOut.println(string2);
 **************************************************************************** */

package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_4 {
  public static void main(String[] args) {
    // Answer: "world\nhello"

    String string1 = "hello";
    String string2 = string1;
    string1 = "world";
    StdOut.println(string1);
    StdOut.println(string2);
  }
}
