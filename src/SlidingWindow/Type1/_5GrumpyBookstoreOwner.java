package SlidingWindow.Type1;

/*
Problem Statement:
The owner of a bookstore keeps a record of the number of customers that enter
the store every minute. The owner is sometimes grumpy.

You are given two integer arrays:
1. customers[i] – number of customers at minute i
2. grumpy[i] – 1 if the owner is grumpy at minute i, otherwise 0

When the owner is grumpy, customers are not satisfied.
The owner can use a secret technique for exactly 'minutes' consecutive minutes
to keep themselves from being grumpy.

Return the maximum number of satisfied customers.

Example:
Input:
customers = [1,0,1,2,1,1,7,5]
grumpy    = [0,1,0,1,0,1,0,1]
minutes = 3

Output:
16
*/

public class _5GrumpyBookstoreOwner {

    // Fixed Size Sliding Window
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        // Step 1: Customers always satisfied
        int base = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        // Step 2: Sliding window for extra satisfied customers
        int extra = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }

        int maxExtra = extra;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
            maxExtra = Math.max(maxExtra, extra);
        }

        return base + maxExtra;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =    {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;

        int result = maxSatisfied(customers, grumpy, minutes);
        System.out.println("Maximum satisfied customers: " + result);
    }
}

