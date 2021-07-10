/* *****************************************************************************
 *  Exercise: 1.3.8
 *
 *  Description:
 *  ------------
 *  Give the contents and size of the array for DoublingStackOfStrings with the input
 *  it was - the best - of times - - - it was - the - -
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_8 {
  private static String[] input = new String[]{
      "it",
      "was",
      "-",
      "the",
      "best",
      "-",
      "of",
      "times",
      "-",
      "-",
      "-",
      "it",
      "was",
      "-",
      "the",
      "-",
      "-"
  };

  public static void main(String[] args) {
    ResizingArrayStack<String> stack = new ResizingArrayStack<>();

    for (int i = 0; i < input.length; i++) {
      if (input[i].equals("-")) {
        stack.pop();
      } else {
        stack.push(input[i]);
      }
    }

    stack.printArrayStats();
    // Answer
    // Size: 2
    // Contents: "it" null
  }

  private static class ResizingArrayStack<Item> {
    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];

    private int N = 0; // number of items

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    public void printArrayStats() {
      StdOut.println("Array size: " + a.length);
      StdOut.print("Contents: ");
      for (int i = 0; i < a.length; i++) {
        StdOut.print(a[i] + " ");
      }
      StdOut.println();
    }

    private void resize(int max) {
      @SuppressWarnings("unchecked") Item[] temp = (Item[]) new Object[max];
      for (int i = 0; i < N; i++) {
        temp[i] = a[i];
      }
      a = temp;
    }

    public void push(Item item) {
      if (N == a.length) {
        resize(2 * a.length);
      }
      a[N++] = item;
    }

    public Item pop() {
      Item item = a[--N];
      a[N] = null;
      if (N > 0 && N == a.length / 4) {
        resize(a.length / 2);
      }

      return item;
    }
  }
}
