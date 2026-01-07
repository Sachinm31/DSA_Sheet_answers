package Greedy.Type1;

public class _2LemonadeChange {

    /*
     * ============================================================
     * LeetCode 860: Lemonade Change
     * ============================================================
     *
     * Problem Statement:
     * You are selling lemonade for $5 each.
     * Customers pay with bills of $5, $10, or $20.
     *
     * You must provide correct change to each customer.
     * Initially, you have no money.
     *
     * Return true if you can give correct change
     * to every customer in order, else false.
     *
     * Example 1:
     * bills = [5,5,5,10,20]
     * Output: true
     *
     * Example 2:
     * bills = [5,5,10,10,20]
     * Output: false
     *
     * Constraints:
     * 1 <= bills.length <= 100000
     * bills[i] is either 5, 10, or 20
     */

    /*
     * ============================================================
     * Greedy Thinking:
     * ============================================================
     *
     * Lemonade costs $5.
     *
     * Key Observations:
     * - $5 bill → no change needed
     * - $10 bill → need one $5
     * - $20 bill → need $15 change
     *
     * For $20 change:
     * - Best choice: one $10 + one $5
     * - Otherwise: three $5 bills
     *
     * WHY greedy works?
     * - $5 bills are most valuable for future change.
     * - Always try to save $5 bills when possible.
     */

    // Static method as requested
    public static boolean lemonadeChange(int[] bills) {

        int five = 0; // count of $5 bills
        int ten = 0;  // count of $10 bills

        // Process each customer one by one
        for (int bill : bills) {

            if (bill == 5) {
                // No change needed
                five++;
            }
            else if (bill == 10) {
                // Need $5 change
                if (five == 0) {
                    return false; // cannot give change
                }
                five--;
                ten++;
            }
            else { // bill == 20
                /*
                 * Need $15 change
                 * Priority:
                 * 1) One $10 + one $5
                 * 2) Three $5 bills
                 */
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false; // cannot give change
                }
            }
        }

        return true; // all customers handled successfully
    }

    /*
     * ============================================================
     * Time & Space Complexity:
     * ============================================================
     *
     * Time Complexity:
     * - O(n) → single pass through bills
     *
     * Space Complexity:
     * - O(1) → only two counters used
     */

    // Main method for local testing
    public static void main(String[] args) {

        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        int[] bills3 = {5, 5, 5, 5, 20, 20};

        System.out.println(lemonadeChange(bills1)); // true
        System.out.println(lemonadeChange(bills2)); // false
        System.out.println(lemonadeChange(bills3)); // true
    }
}
