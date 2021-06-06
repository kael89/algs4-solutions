/* *****************************************************************************
 *  Exercise: 1.1.2
 *
 *  Description:
 *  ------------
 *  Give the type and value of each of the following expressions:
 *  a. (1 + 2.236)/2
 *  b. 1 + 2 + 3 + 4.0
 *  c. 4.1 >= 4
 *  d. 1 + 2 + "3"
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_2 {
  public static void main(String[] args) {
    StdOut.println((1 + 2.236) / 2); // float, 1.618
    StdOut.println(1 + 2 + 3 + 4.0); // float, 10.0
    StdOut.println(4.1 >= 4); // boolean, true
    StdOut.println(1 + 2 + "3"); // string, "33"
  }
}
