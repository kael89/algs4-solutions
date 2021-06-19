/* *****************************************************************************
 *  Exercise: 1.1.4
 *
 *  Description:
 *  ------------
 *  What (if anything) is wrong with each of the following statements?
 *  a. if (a > b) then c = 0;
 *  b. if a > b { c = 0; }
 *  c. if (a > b) c = 0;
 *  d. if (a > b) c = 0 else b = 0;
 **************************************************************************** */

package chapter1.section1;

public class Exercise1_1_4 {
  public static void main(String[] args) {
    // a. `then` is invalid syntax in Java
    // b. missing parentheses in `a > b`
    // c. all good
    // d. missing semicolon in `c = 0`
  }
}
