package SlidingWindow.Type4;

/*
 PROBLEM STATEMENT (LeetCode 202 - Happy Number):

 A number is called happy if we repeatedly replace the number
 by the sum of the squares of its digits and eventually reach 1.

 If the process results in an endless cycle that does not include 1,
 then the number is not happy.
*/

public class _5HappyNumber {

    /*
     METHOD 1 (BEST & INTERVIEW SAFE):
     Floyd's Cycle Detection (Slow & Fast Pointer)

     Idea:
     - Treat the number transformation as a linked list
     - If cycle ends at 1 → happy
     - Else → unhappy
    */
    public static boolean isHappyFloyd(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);                  // move 1 step
            fast = findSquare(findSquare(fast));     // move 2 steps
        } while (slow != fast);

        return slow == 1;
    }

    /*
     METHOD 2 (OPTIMIZED MATHEMATICAL METHOD):

     Observation:
     All unhappy numbers fall into this cycle:
     4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4

     So:
     - If we reach 1 → happy
     - If we reach 4 → unhappy
    */
    public static boolean isHappyOptimized(int n) {

        while (n != 1 && n != 4) {
            n = findSquare(n);
        }
        return n == 1;
    }

    /*
     Helper function:
     Returns sum of squares of digits of a number
    */
    private static int findSquare(int num) {

        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // Main method for testing
    public static void main(String[] args) {

        int n = 19;

        System.out.println("Using Floyd's Method: " + isHappyFloyd(n));
        System.out.println("Using Optimized Method: " + isHappyOptimized(n));
    }
}
