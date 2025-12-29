package BinarySearch.BS2DArrsy;

/*
 Problem Statement:
 ------------------
 Given a binary matrix where each row is sorted (all 0s first, then 1s),
 find the index of the row that contains the minimum number of 1s.

 If multiple rows have the same minimum number of 1s,
 return the first such row (0-based index).

 Example:
 --------
 Input:
 0 0 1 1
 0 0 0 1
 0 0 0 0

 Output:
 Row index = 2
*/

public class _1RowWithMaxOnes {

    public static int minRow(int nums[][]) {
        int m = nums.length;
        int n = nums[0].length;

        int minCount = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < m; i++) {
            int lb = lowerBound(nums[i], n);
            int count;

            if (lb == -1) {
                count = 0;           // no 1s in this row
            } else {
                count = n - lb;      // number of 1s
            }

            if (minCount > count) {
                minCount = count;
                index = i;
            }
        }
        return index;
    }

    // Lower bound: first index where value == 1
    public static int lowerBound(int nums[], int n) {
        int start = 0;
        int end = n - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // ✅ FIXED

            if (nums[mid] == 1) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}
        };

        int rowIndex = minRow(matrix);

        System.out.println("Row with minimum number of 1s (0-based index): " + rowIndex);
    }
}
