package cognizant;
import java.util.*;
/*
2. Card Game (Minimum Moves)

Problem Statement:
You have a deck of N cards, where N is always an odd number.
Each card has a unique value. Your task is to bring the
highest-numbered card to the beginning of the deck (index 0)
using the minimum number of moves.

Allowed Move:
In one move, you can take the middle card of the deck
(card at index N/2) and move it either to:
- the beginning of the deck, or
- the end of the deck.

Logic:
To bring any card to the front:
- The card must first reach the middle position.
- Once it is in the middle, one additional move is required
  to move it to the front.

Number of moves required:
|currentIndex - middleIndex| + 1

Exception:
If the highest-numbered card is already at index 0,
then the number of moves required is 0.

Input Format:
input1: Integer N (number of cards, always odd)
input2: Integer array A (card values)

Output Format:
Return an integer representing the minimum number of moves
required to bring the highest-numbered card to the front.
*/

public class cardGame {
    public static int minimumMoves(int input1, int[] input2) {
        // input1: N (Number of cards)
        // input2: A (Array of card numbers)

        // Write code here...
       return 3;
    }


}
