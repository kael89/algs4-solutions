/* *****************************************************************************
 *  Exercise: 1.3.10
 *
 *  Description:
 *  ------------
 *  Suppose that a client performs an intermixed sequence of (queue) enqueue and dequeue operations.
 *  The enqueue operations put the integers 0 through 9 in order onto the queue;
 *  the dequeue operations print out the return value
 *
 *  Which of the following sequence(s) could not occur?
 *  a. 0 1 2 3 4 5 6 7 8 9
 *  b. 4 6 8 7 5 3 2 9 0 1
 *  c. 2 5 6 7 4 8 9 3 1 0
 *  d. 4 3 2 1 0 5 6 7 8 9
 **************************************************************************** */

package chapter1.section3;

public class Exercise1_3_13 {
  // Answer: b, c and d could not occur. In other words, dequeue is bound to
  // print the items in the order they were inserted (LIFO)
}
