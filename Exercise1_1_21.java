/* *****************************************************************************
 *  Exercise: 1.1.21
 *
 *  Description:
 *  ------------
 *  Write a program that reads in lines from standard input with each line containing
 *  a name and two integers and then uses printf() to print a table with a column of
 *  the names, the integers, and the result of dividing the first by the second, accurate to
 *  three decimal places. You could use a program like this to tabulate batting averages for
 *  baseball players or grades for students.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1_1_21 {
  public static void main(String[] args) {
    List<Record> records = readRecords();
    StdOut.println();
    RecordTable.print(records);
  }

  public static List<Record> readRecords() {
    List<Record> records = new ArrayList<Record>();

    while (!StdIn.isEmpty()) {
      String name = StdIn.readString();
      int int1 = StdIn.readInt();
      int int2 = StdIn.readInt();

      Record record = new Record(name, int1, int2);
      records.add(record);
    }

    return records;
  }

  private static class Record {
    public final String name;

    public final int int1;

    public final int int2;

    public final double fraction;

    public Record(String name, int int1, int int2) {
      this.name = name;
      this.int1 = int1;
      this.int2 = int2;
      this.fraction = ((double) int1 / (double) int2);
    }
  }

  private static class RecordTable {
    private static final String[] HEADERS = new String[]{"Name", "Value 1", "Value 2", "Average"};

    public static void print(List<Record> records) {
      List<String[]> rows = records.stream()
          .map(RecordTable::recordToRow)
          .collect(Collectors.toCollection(ArrayList::new));
      rows.add(0, HEADERS);
      int[] columnSizes = getColumnSizes(rows);

      TableRow.printWithBorders(rows.get(0), columnSizes);
      for (int i = 1; i < rows.size(); i++) {
        TableRow.print(rows.get(i), columnSizes);
      }
    }

    private static String[] recordToRow(Record record) {
      return new String[]{
          record.name,
          Integer.toString(record.int1),
          Integer.toString(record.int2),
          String.format("%.3f", record.fraction)
      };
    }

    private static int[] getColumnSizes(List<String[]> rows) {
      int[] sizes = new int[rows.get(0).length];
      for (int i = 0; i < sizes.length; i++) {
        int finalI = i;
        sizes[i] = rows.stream().map(row -> row[finalI].length()).max(Integer::compare).get();
      }

      return sizes;
    }
  }

  private static class TableRow {
    private static final char HORIZONTAL_BORDER = '-';

    private static final char VERTICAL_BORDER = '|';

    public static void print(String[] columns, int[] columnSizes) {
      for (int i = 0; i < columnSizes.length; i++) {
        printCell(columns[i], i, columnSizes[i]);
      }
      StdOut.println();
    }

    public static void printWithBorders(String[] columns, int[] columnSizes) {
      print(columns, columnSizes);
      printHorizontalBorder(columnSizes);
    }

    public static void printHorizontalBorder(int[] columnSizes) {
      for (int i = 0; i < columnSizes.length; i++) {
        String border = buildBorder(columnSizes[i]);
        printCell(border, i, columnSizes[i]);
      }
      StdOut.println();
    }

    private static String buildBorder(int size) {
      StringBuilder sr = new StringBuilder();
      for (int i = 0; i < size; i++) {
        sr.append(HORIZONTAL_BORDER);
      }
      return sr.toString();
    }

    private static void printCell(String cell, int columnId, int size) {
      boolean isFirst = columnId == 0;
      StdOut.printf("%s %" + size + "s %s", isFirst ? VERTICAL_BORDER : "", cell, VERTICAL_BORDER);
    }
  }
}
