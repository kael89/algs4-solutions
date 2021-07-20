/* *****************************************************************************
 *  Exercise: 1.3.31
 *
 *  Description:
 *  ------------
 *  Implement a nested class DoubleNode for building doubly-linked lists, where each node contains
 *  a reference to the item preceding it and the item following it in the list
 *  (null if there is no such item). Then implement static methods for the following tasks:
 *  insert at the beginning, insert at the end, remove from the beginning, remove from the end,
 *  insert before a given node, insert after a given node, and remove a given node.
 **************************************************************************** */

package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1_3_31 {
  public static void main(String[] args) {
    Command.printHelp();

    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    while (!StdIn.isEmpty()) {
      String commandString = StdIn.readLine();
      Command command = new Command(commandString);
      command.exec(list);

      StdOut.print("List: ");
      list.print();
      StdOut.println("\n");
    }
  }

  private static void insertBeforeNode(DoublyLinkedList<String> list, DoubleNode<String> baseNode, String item) {
    DoubleNode<String> newNode = new DoubleNode<String>(item);

    if (baseNode.previous == null) {
      // Base node was first in list, re-assign first
      list.first = baseNode;
    } else {
      baseNode.previous.next = newNode;
      newNode.previous = baseNode.previous;
    }

    baseNode.previous = newNode;
    newNode.next = baseNode;
  }

  private static void insertAfterNode(DoublyLinkedList<String> list, DoubleNode<String> baseNode, String item) {
    DoubleNode<String> newNode = new DoubleNode<String>(item);

    if (baseNode.next == null) {
      // Base node was last in list, re-assign last
      list.last = baseNode;
    } else {
      baseNode.next.previous = newNode;
      newNode.next = baseNode.next;
    }

    baseNode.next = newNode;
    newNode.previous = baseNode;
  }

  private static String remove(DoublyLinkedList<String> list, DoubleNode<String> node) {
    if (node.previous == null) {
      // Removed node was first in list, re-assign first
      list.first = node.next;
    } else {
      node.previous.next = node.next;
    }

    if (node.next == null) {
      // Removed node was last in list, re-assign last
      list.last = node.previous;
    } else {
      node.next.previous = node.previous;
    }

    return node.item;
  }

  private static class Command {
    private static final String DEFAULT_TYPE = "+e";

    private String type;

    private String item;

    private int index;

    public Command(String commandString) {
      int spacePosition = commandString.indexOf(" ");
      boolean isUnary = commandString.startsWith("-");
      boolean hasSpaceSeparator = spacePosition > -1 && spacePosition < commandString.length() - 1;

      if (!isUnary && !hasSpaceSeparator) {
        type = DEFAULT_TYPE;
        item = commandString;
      } else {
        String typeString = isUnary ? commandString : commandString.substring(0, spacePosition);
        String[] typeParts = parseTypeString(typeString);
        type = typeParts[0];
        index = Integer.parseInt(typeParts[1]);
        if (!isUnary) {
          item = commandString.substring(spacePosition + 1);
        }
      }
    }

    private static String[] parseTypeString(String typeString) {
      Matcher matcher = Pattern.compile("([\\+-]{0,2})(\\d+)").matcher(typeString);

      return matcher.find() ?
              new String[]{matcher.group(1), matcher.group(2)} :
              new String[]{typeString, "-1"};
    }

    private static void printHelp() {
      StdOut.println("Symbols: ");
      StdOut.println("+s        insert at the beginning");
      StdOut.println("+e        insert at the end (default)");
      StdOut.println("++{id}    insert after index {id}");
      StdOut.println("+-{id}    insert before index {id}");
      StdOut.println("-s        remove from the beginning");
      StdOut.println("-e        remove from the end");
      StdOut.println("-{id}     remove at index {id}");
      StdOut.println();
    }

    public void exec(DoublyLinkedList<String> list) {
      if (type.equals("+s")) {
        list.insertAtStart(item);
        StdOut.printf("Inserted %s at the beginning\n", item);
      } else if (type.equals("+e")) {
        list.insertAtEnd(item);
        StdOut.printf("Inserted %s at the end\n", item);
      } else if (type.equals("-s")) {
        String item = list.removeFromStart();
        StdOut.printf("Removed %s from the beginning\n", item);
      } else if (type.equals("-e")) {
        String item = list.removeFromEnd();
        StdOut.printf("Removed %s from the end\n", item);
      } else if (type.startsWith("++")) {
        insertAfterNode(list, list.get(index), item);
        StdOut.printf("Inserted %s after index %d\n", item, index);
      } else if (type.startsWith("+-")) {
        insertBeforeNode(list, list.get(index), item);
        StdOut.printf("Inserted %s before index %d\n", item, index);
      } else if (type.startsWith("-")) {
        String item = remove(list, list.get(index));
        StdOut.printf("Removed %s at index %d\n", item, index);
      } else {
        throw new UnsupportedOperationException("Invalid command type: " + type);
      }
    }
  }

  private static class DoubleNode<Item> {
    Item item;

    DoubleNode<Item> previous;

    DoubleNode<Item> next;

    DoubleNode(Item item) {
      this.item = item;
    }
  }

  private static class DoublyLinkedList<Item> {
    private DoubleNode<Item> first;

    private DoubleNode<Item> last;

    public DoubleNode<Item> get(int k) {
      if (k < 0) {
        throw new Error("Index must be >= 0");
      }
      if (first == null) {
        throw new IllegalArgumentException("List is empty");
      }

      DoubleNode<Item> current = first;
      for (int i = 1; i <= k; i++) {
        current = current.next;
        if (current == null) {
          throw new IllegalArgumentException("Index " + k + " is out of bounds");
        }
      }

      return current;
    }

    public void insertAtStart(Item item) {
      DoubleNode<Item> node = new DoubleNode<Item>(item);

      if (first == null) {
        first = node;
        last = node;
      } else {
        node.next = first;
        first.previous = node;
        first = node;
      }
    }

    public void insertAtEnd(Item item) {
      DoubleNode<Item> node = new DoubleNode<Item>(item);

      if (first == null) {
        first = node;
        last = node;
      } else {
        node.previous = last;
        last.next = node;
        last = node;
      }
    }

    public Item removeFromStart() {
      if (first == null) {
        throw new IllegalArgumentException("List underflow");
      }

      Item item = first.item;
      first = first.next;
      if (first == null) {
        // List is now empty
        last = null;
      } else {
        first.previous = null;
      }

      return item;
    }

    public Item removeFromEnd() {
      if (last == null) {
        throw new IllegalArgumentException("List underflow");
      }

      Item item = last.item;
      last = last.previous;
      if (last == null) {
        // List is now empty
        first = null;
      } else {
        last.next = null;
      }

      return item;
    }

    public void print() {
      DoubleNode<Item> temp = first;
      while (temp != null) {
        StdOut.print(temp.item + " ");
        temp = temp.next;
      }
    }
  }
}
