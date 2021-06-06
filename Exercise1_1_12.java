/* *****************************************************************************
 *  Exercise: 1.1.12
 *
 *  Description:
 *  ------------
 *  int[] a = new int[10];
 *  for (int i = 0; i < 10; i++)
 *    a[i] = 9 - i;
 *  for (int i = 0; i < 10; i++)
 *    a[i] = a[a[i]];
 *  for (int i = 0; i < 10; i++)
 *    System.out.println(i);
 **************************************************************************** */

public class Exercise1_1_12 {
  public static void main(String[] args) {
    // Answer: all the integers in [0, 9] in ascending order

    int[] a = new int[10];
    for (int i = 0; i < 10; i++)
      a[i] = 9 - i;
    for (int i = 0; i < 10; i++)
      a[i] = a[a[i]];
    for (int i = 0; i < 10; i++)
      System.out.println(i);
  }
}
