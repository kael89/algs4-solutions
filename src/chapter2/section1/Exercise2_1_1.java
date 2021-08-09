/* *****************************************************************************
 *  Exercise: 2.1.1
 *
 *  Description:
 *  ------------
 *  Show, in the style of the example trace with Algorithm 2.1, how selection sort
 *  sorts the array E A S Y Q U E S T I O N.
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_1 {
  public static void main(String[] args) {
    // Answer
    //
    //  i | min |  0   1   2   3   4   5   6   7   8   9  10   11
    // -- | --- | -----------------------------------------------
    //    |     |  E   A   S   Y   Q   U   E   S   T   I   O   N
    //  0 |   2 |  E  |A|  S   Y   Q   U   E   S   T   I   O   N
    //  1 |   2 |  A\ |E|  S   Y   Q   U   E   S   T   I   O   N
    //  2 |   6 |  A   E\  S   Y   Q   U  |E|  S   T   I   O   N
    //  3 |   9 |  A   E   E\  Y   Q   U   S   S   T  |I|  O   N
    //  4 |  11 |  A   E   E   I\  Q   U   S   S   T   Y   O  |N|
    //  5 |  10 |  A   E   E   I   N\  U   S   S   T   Y  |O|  Q
    //  6 |  11 |  A   E   E   I   N   O\  S   S   T   Y   U  |Q|
    //  7 |   7 |  A   E   E   I   N   O   Q\ |S|  T   Y   U   S
    //  8 |  11 |  A   E   E   I   N   O   Q   S\  T   Y   U  |S|
    //  9 |  11 |  A   E   E   I   N   O   Q   S   S\  Y   U  |T|
    // 10 |  10 |  A   E   E   I   N   O   Q   S   S   T\ |U|  Y
    // 11 |  11 |  A   E   E   I   N   O   Q   S   S   T   U\ |Y|
    //          |  A   E   E   I   N   O   Q   S   S   T   U   Y
  }
}
