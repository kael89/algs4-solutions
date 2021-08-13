/* *****************************************************************************
 *  Exercise: 2.1.13
 *
 *  Description:
 *  ------------
 *  Deck sort. Explain how you would put a deck of cards in order by suit (in the
 *  order spades, hearts, clubs, diamonds) and by rank within each suit, with the restriction
 *  that the cards must be laid out face down in a row, and the only allowed operations are
 *  to check the values of two cards and to exchange two cards (keeping them face down).
 **************************************************************************** */

package chapter2.section1;

public class Exercise2_1_13 {
  public static void main(String[] args) {
    // Answer
    // ------
    // One approach is the following:
    //
    // Definitions
    // -----------
    // - Correct position of a card: starting at 1, a number that represents the final position
    //   of the card in a sorted deck.
    //   Examples:
    //   - The final position of "10 of spades" is 10
    //   - The final position of "3 of clubs" is 2 * 13 + 3 = 29
    //
    // Setup
    // -----
    // We will need to keep track the following counters:
    //  - i: position of a card to be opened in each check. Initial value: 1
    //  - j: position of another card to be opened in each check. Initial value: 2
    //  - (optional) correctPositionCount: how many cards have been placed in their correct position.
    //    Initial value: 0. Keeping track of this counter is an optional optimization
    //
    //
    // Steps
    // -----
    // 1. Check the cards currently at position i (card A) and j (card B)
    // 2. - If card A is not in its correct position, exchange it with the card that it is there.
    //    - If not, i = i + 1. Repeat this step until i <> j or i = 52 (max index)
    // 3. Increment correctPositionCount by one
    // 4. Repeat steps 2 and 3 for card B, using j this time
    // 5. If correctPositionCount < 5 2 and j < 53, go to step 2
  }
}
