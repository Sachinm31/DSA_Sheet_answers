package Greedy.Type2_IntervalScheduling;

import java.util.Arrays;

public class _1NonOverlappingIntervals {

    /*
     * ============================================================
     * LeetCode 435: Non-overlapping Intervals
     * ============================================================
     *
     * Problem Statement:
     * You are given an array of intervals where
     * intervals[i] = [starti, endi].
     *
     * Return the minimum number of intervals you need to remove
     * to make the rest of the intervals non-overlapping.
     *
     * Two intervals overlap if:
     *   curr.start < prev.end
     *
     * Example:
     * intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output = 1
     *
     * Constraints:
     * 1 <= intervals.length <= 10^5
     */

    /*
     * ============================================================
     * Greedy Strategy (Interval Scheduling):
     * ============================================================
     *
     * Key Insight:
     * - To keep maximum number of intervals,
     *   always choose the interval that ends earliest.
     *
     * Why?
     * - Earlier ending interval leaves more room
     *   for future intervals.
     *
     * This is the classic:
     * 👉 Interval Scheduling / Activity Selection problem
     */

    // Static method as requested
    public static int eraseOverlapIntervals(int[][] intervals) {

        // Edge case
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Step 1: Sort intervals by END time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removals = 0;
        int prevEnd = intervals[0][1];

        // Step 2: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlap condition
            if (intervals[i][0] < prevEnd) {
                // Overlap → remove current interval
                removals++;
            } else {
                // No overlap → keep it
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }

    /*
     * ============================================================
     * Time & Space Complexity:
     * ============================================================
     *
     * Time Complexity:
     * - O(n log n) due to sorting
     *
     * Space Complexity:
     * - O(1) extra space
     */

    // Main method for local testing
    public static void main(String[] args) {

        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        int[][] intervals3 = {{1,2},{2,3}};

        System.out.println(eraseOverlapIntervals(intervals1)); // Expected: 1
        System.out.println(eraseOverlapIntervals(intervals2)); // Expected: 2
        System.out.println(eraseOverlapIntervals(intervals3)); // Expected: 0
    }
}
