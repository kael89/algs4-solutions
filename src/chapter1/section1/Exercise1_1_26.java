/* *****************************************************************************
 *  Exercise: 1.1.26
 *
 *  Description:
 *  ------------
 *  Sorting three numbers. Suppose that the variables a, b, c, and t are all of the
 *  same numeric primitive type. Show that the following code puts a, b, and c in ascending
 *  order:
 *
 *  if (a > b) { t = a; a = b; b = t; }
 *  if (a > c) { t = a; a = c; c = t; }
 *  if (b > c) { t = b; b = c; c = t; }
 **************************************************************************** */

package chapter1.section1;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdIn;

public class Exercise1_1_26 {
  public static void main(String[] args) {
    int a = StdIn.readInt();
    int b = StdIn.readInt();
    int c = StdIn.readInt();

    StdArrayIO.print(sort(a, b, c));
  }

  private static int[] sort(int a, int b, int c) {
    int t;

    // Let's call the original values of (a, b, c): (A, B, C)
    // There are 6 cases (variables in ascending order):
    // 1. A < B < C
    // 2. A < C < B
    // 3. B < A < C
    // 4. B < C < A
    // 5. C < A < B
    // 6. C < B < A

    // Initial values:
    // | # | a | b | c |
    // | - | - | - | - |
    // | 1 | A | B | C |
    // | 2 | A | B | C |
    // | 3 | A | B | C |
    // | 4 | A | B | C |
    // | 5 | A | B | C |
    // | 6 | A | B | C |

    if (a > b) {
      t = a;
      a = b;
      b = t;
    }
    // After this code:
    // | # | a | b | c |
    // | - | - | - | - |
    // | 1 | A | B | C |
    // | 2 | A | B | C |
    // | 3 | B | A | C |
    // | 4 | B | A | C |
    // | 5 | A | B | C |
    // | 6 | B | A | C |

    if (a > c) {
      t = a;
      a = c;
      c = t;
    }
    // After this code:
    // | # | a | b | c |
    // | - | - | - | - |
    // | 1 | A | B | C |
    // | 2 | A | B | C |
    // | 3 | B | A | C |
    // | 4 | B | A | C |
    // | 5 | C | B | A |
    // | 6 | C | A | B |

    if (b > c) {
      t = b;
      b = c;
      c = t;
    }
    // After this code:
    // | # | a | b | c |
    // | - | - | - | - |
    // | 1 | A | B | C | ✔
    // | 2 | A | C | B | ✔
    // | 3 | B | A | C | ✔
    // | 4 | B | C | A | ✔
    // | 5 | C | A | B | ✔
    // | 6 | C | B | A | ✔

    return new int[]{a, b, c};
  }
}
