/* *****************************************************************************
 *  Exercise: 2.1.4
 *
 *  Description:
 *  ------------
 *  Show, in the style of the example trace with Algorithm 2.2, how insertion sort
 *  sorts the array E A S Y Q U E S T I O N.
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_4 {
  public static void main(String[] args) {
    // Answer
    //
    //  i |  j |  0   1   2   3   4   5   6   7   8   9  10   11
    // -- | -- | -----------------------------------------------
    //    |    |  E   A   S   Y   Q   U   E   S   T   I   O   N
    //  1 |  0 | |A|  E\  S   Y   Q   U   E   S   T   I   O   N
    //  2 |  2 |  A   E  |S|\ Y   Q   U   E   S   T   I   O   N
    //  3 |  3 |  A   E   S  |Y|\ Q   U   E   S   T   I   O   N
    //  4 |  2 |  A   E  |Q|  S   Y\  U   E   S   T   I   O   N
    //  5 |  4 |  A   E   Q   S  |U|  Y\  E   S   T   I   O   N
    //  6 |  2 |  A   E  |E|  Q   S   U   Y\  S   T   I   O   N
    //  7 |  5 |  A   E   E   Q   S  |S|  U   Y\  T   I   O   N
    //  8 |  6 |  A   E   E   Q   S   S  |T|  U   Y\  I   O   N
    //  9 |  3 |  A   E   E  |I|  Q   S   S   T   U   Y\  O   N
    // 10 |  4 |  A   E   E   I  |O|  Q   S   S   T   U   Y\  N
    // 11 |  4 |  A   E   E   I  |N|  O   Q   S   S   T   U   Y\
    //         |  A   E   E   I   N   O   Q   S   S   T   U   Y
  }
}
