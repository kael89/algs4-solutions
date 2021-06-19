/* *****************************************************************************
 *  Exercise: 1.1.8
 *
 *  Description:
 *  ------------
 *   What do each of the following print?
 *   a. System.out.println('b');
 *   b. System.out.println('b' + 'c');
 *   c. System.out.println((char) ('a' + 4));
 *
 *   Explain each outcome.
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_8 {
  public static void main(String[] args) {
    StdOut.println('b'); // 'b'
    StdOut.println('b' + 'c'); // 197 (ascii(b) + ascii(c) => 98 + 99)
    StdOut.println((char) ('a' + 4)); // 'e' (4 chars after 'a')
  }
}
