/* *****************************************************************************
 *  Exercise: 2.1.14
 *
 *  Description:
 *  ------------
 *  Dequeue sort. Explain how you would sort a deck of cards, with the restriction that the only
 *  allowed operations are to look at the values of the top two cards, to exchange the top
 *  two cards and to move the top card to the bottom of the deck.
 **************************************************************************** */

package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exercise2_1_14 {
  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.shuffle();

    StdOut.println("Shuffled deck:");
    StdOut.println(deck);

    StdOut.println("Sorted deck:");
    new DeckSorter().sort(deck);
    StdOut.println(deck);
  }

  static class Card {
    private static final int RANKS_PER_SUIT = 13;

    public final int value;

    public final Suit suit;

    public final int rank;

    public Card next;

    public Card(int value) {
      assert value >= 0 && value < 52 : " Card value must be between 0 and 51";

      this.value = value;
      this.suit = Suit.values()[value / RANKS_PER_SUIT];
      this.rank = value % RANKS_PER_SUIT;
    }

    public String toString() {
      return this.getRankString() + " of " + suit.label + "s";
    }

    private String getRankString() {
      switch (this.rank) {
        case 12:
          return "K";
        case 11:
          return "Q";
        case 10:
          return "J";
        case 0:
          return "A";
        default:
          return Integer.toString(this.rank + 1);
      }
    }

    private enum Suit {
      SPADE(0, "spade"), HEART(1, "heart"), CLUB(2, "club"), DIAMOND(3, "diamond");

      public final int value;

      public final String label;

      Suit(int value, String label) {
        this.value = value;
        this.label = label;
      }

      public String toString() {
        return label;
      }
    }
  }

  static class Deck {
    public static final int SIZE = 52;

    private Card first;

    private Card last;

    public Deck() {
      StdOut.println(Card.RANKS_PER_SUIT);
      int[] orderedValues = new int[SIZE];
      for (int i = 0; i < orderedValues.length; i++) {
        orderedValues[i] = i;
      }
      this.setCards(orderedValues);
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      DeckIterator it = new DeckIterator();
      while (it.hasNext()) {
        sb.append(it.next() + "\n");
      }

      return sb.toString();
    }

    public void shuffle() {
      int[] values = this.getCardValues();
      for (int i = 0; i < 3; i++) {
        StdRandom.shuffle(values);
      }
      this.setCards(values);
    }

    private int[] getCardValues() {
      int[] values = new int[SIZE];
      int i = 0;
      DeckIterator it = new DeckIterator();
      while (it.hasNext()) {
        values[i++] = it.next().value;
      }

      return values;
    }

    private void setCards(int[] values) {
      first = null;
      last = null;

      if (values.length == 0) {
        return;
      }

      first = new Card(values[0]);
      Card current = first;
      for (int i = 1; i < values.length; i++) {
        current.next = new Card(values[i]);
        current = current.next;
      }
      last = current;
      last.next = null;
    }

    public Card[] peekTopPair() {
      return new Card[]{first, first.next};
    }

    public void exchangeTopPair() {
      Card oldFirst = first;

      first = first.next;
      oldFirst.next = first.next;
      first.next = oldFirst;
    }

    public void topToBottom() {
      last.next = first;
      first = first.next;
      last = last.next;
      last.next = null;
    }

    private class DeckIterator implements Iterator<Card> {
      private Card current = first;

      public boolean hasNext() {
        return current != null;
      }

      public Card next() {
        Card card = current;
        current = current.next;
        return card;
      }
    }
  }

  static class DeckSorter {
    public void sort(Deck deck) {
      for (int i = Deck.SIZE - 1; i > 1; i--) {
        int j = 0;
        // Search the deck until you find the current max (51, 50, 49...)
        while (true) {
          Card[] topCards = deck.peekTopPair();

          if (topCards[0].value == i) {
            deck.exchangeTopPair();
            deck.topToBottom();
            j += 1;
            break;
          }
          if (topCards[1].value == i) {
            deck.topToBottom();
            j += 1;
            break;
          }

          deck.topToBottom();
          deck.topToBottom();
          j += 2;
        }

        // Current max is found, keep it on top and place the rest of (unsorted) cards to bottom
        for (; j < i; j++) {
          deck.exchangeTopPair();
          deck.topToBottom();
        }
        // Last cards in the deck are already sorted in previous passes, just place them to bottom
        for (; j < Deck.SIZE; j++) {
          deck.topToBottom();
        }
      }

      // Last unsorted pair can be sorted with a simple exchange
      Card[] topCards = deck.peekTopPair();
      if (topCards[0].value == 1) {
        deck.exchangeTopPair();
      }
    }
  }
}
