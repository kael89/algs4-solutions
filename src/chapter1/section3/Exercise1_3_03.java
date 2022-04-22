/* *****************************************************************************
 *  Exercise:
 *
 *  Description:
 *  ------------
 *  Suppose that a client performs an intermixed sequence of (stack) push and pop operations.
 *  The push operations put the integers 0 through 9 in order onto the stack;
 *  the pop operations print out the return values.
 *  Which of the following sequence(s) could not occur?
 *
 *  a. 4 3 2 1 0 9 8 7 6 5
 *  b. 4 6 8 7 5 3 2 9 0 1
 *  c. 2 5 6 7 4 8 9 3 1 0
 *  d. 4 3 2 1 0 5 6 7 8 9
 *  e. 1 2 3 4 5 6 9 8 7 0
 *  f. 0 4 6 5 3 8 1 7 2 9
 *  g. 1 4 7 9 8 6 5 3 0 2
 *  h. 2 1 4 3 6 5 8 7 9 0
 **************************************************************************** */

package chapter1.section3;

public class Exercise1_3_3 {
  // a ✔ => push(0 1 2 3 4) pop(4 3 2 1 0) push(5 6 7 8 9) pop(9 8 7 6 5)
  // b ✘ (0 1 is invalid)
  // c ✔ => push(0 1 2) pop(2) push(3 4 5) pop(5) push_pop(6) push_pop(7) pop(4) push_pop(8) push_pop(9) pop(3) pop(1) pop(0)
  // d ✔ => push(0 1 2 3 4) pop(4 3 2 1 0) push_pop(5) push_pop(6) push_pop(7) push_pop(8) push_pop(9)
  // e ✔ => push(0) push_pop(1) push_pop(2) push_pop(3) push_pop(4) push_pop(5) push_pop(6) push(7 8 9) pop(9 8 7 0)
  // f ✘ (1 7 2 is invalid)
  // g ✘ (0 2 is invalid)
  // h ✔ => push(0 1 2) pop(2 1) push(3 4) pop(4 3) push(5 6) pop(6 5) pop(7 8) pop(8 7) push_pop(9) pop(0)
}
