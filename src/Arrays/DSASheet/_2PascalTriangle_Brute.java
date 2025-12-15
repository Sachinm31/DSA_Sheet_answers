package Arrays.DSASheet;
/*
Given an integer numRows, return the first numRows of Pascal's Triangle.

In Pascal's Triangle:
- The first and last element of every row is 1
- Each inner element is the sum of the two elements directly above it

Example:
Input: numRows = 5
Output:
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class _2PascalTriangle_Brute {
        public static void main(String[] args) {
            int n = 5;

            for (int i = 0; i < n; i++) {
                int val = 1;
                for (int j = 0; j <= i; j++) {
                    System.out.print(val + " ");
                    val = val * (i - j) / (j + 1);
                }
                System.out.println();
            }
        }

}
