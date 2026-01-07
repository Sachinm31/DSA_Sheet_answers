package Greedy.Type1;

import java.util.Arrays;

public class _1AssignCookies {

    /*
     * ============================================================
     * LeetCode 455: Assign Cookies
     * ============================================================
     *
     * Problem Statement:
     * You are given two integer arrays:
     * - g[] : greed factor of each child
     * - s[] : size of each cookie
     *
     * Each child can receive at most one cookie.
     * A child is satisfied if cookie size >= child's greed factor.
     *
     * Goal:
     * Maximize the number of satisfied children.
     *
     * Example:
     * g = [1,2,3]
     * s = [1,1]
     * Output = 1
     *
     * Constraints:
     * 1 <= g.length, s.length <= 3 * 10^4
     * 1 <= g[i], s[i] <= 10^9
     */

    /*
     * ============================================================
     * Greedy Thinking:
     * ============================================================
     *
     * 1. We want to satisfy as many children as possible.
     * 2. Greedy choice:
     *    - Give the smallest possible cookie
     *      to the least greedy child.
     *
     * Why?
     * - Small cookies can't satisfy greedy children.
     * - Big cookies should be saved for greedy children.
     *
     * Strategy:
     * - Sort both arrays.
     * - Use two pointers:
     *   i -> children
     *   j -> cookies
     *
     * If cookie[j] >= greed[i]:
     *   - child is satisfied
     *   - move both pointers
     * Else:
     *   - cookie too small
     *   - try next bigger cookie
     */

    // Static method as requested
    public static int findContentChildren(int[] g, int[] s) {

        // Step 1: Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;   // pointer for children
        int cookie = 0;  // pointer for cookies
        int satisfied = 0;

        // Step 2: Assign cookies greedily
        while (child < g.length && cookie < s.length) {

            // If current cookie can satisfy current child
            if (s[cookie] >= g[child]) {
                satisfied++;   // child satisfied
                child++;       // move to next child
                cookie++;      // move to next cookie
            } else {
                // Cookie too small, try a bigger one
                cookie++;
            }
        }

        return satisfied;
    }

    /*
     * ============================================================
     * Time & Space Complexity:
     * ============================================================
     *
     * Sorting:
     * - O(n log n + m log m)
     *
     * Two-pointer traversal:
     * - O(n + m)
     *
     * Overall Time Complexity:
     * - O(n log n)
     *
     * Space Complexity:
     * - O(1) extra space (ignoring sorting internals)
     */

    // Main method for local testing
    public static void main(String[] args) {

        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};

        System.out.println("Satisfied children (Test 1): " +
                findContentChildren(g1, s1)); // Expected: 1

        System.out.println("Satisfied children (Test 2): " +
                findContentChildren(g2, s2)); // Expected: 2
    }
}
