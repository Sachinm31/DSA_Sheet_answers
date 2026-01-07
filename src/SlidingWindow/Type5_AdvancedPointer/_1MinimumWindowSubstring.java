package SlidingWindow.Type5_AdvancedPointer;
/*
Problem: Minimum Window Substring (LeetCode 76)

Given two strings s and t, return the minimum window substring of s
such that every character in t (including duplicates) is included
in the window.

If no such substring exists, return an empty string "".

Example:
Input:  s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Concept:
- Sliding Window (Variable Size)
- Frequency Array
- Expand window to make it valid
- Shrink window to make it minimum
*/

public class _1MinimumWindowSubstring {

    // Static method so it can be called from main directly
    public static String minWindow(String s, String t) {

        // Edge case
        if (s.length() < t.length())
            return "";

        int minLen = Integer.MAX_VALUE; // length of minimum window
        int start = 0;                  // left pointer
        int startIndex = 0;             // starting index of best window
        int count = t.length();         // number of chars still needed

        // Frequency array for characters in t
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        // Right pointer expands the window
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // If char is needed, reduce count
            if (freq[ch] > 0) {
                count--;
            }
            freq[ch]--; // include char in window

            // When window is valid, try shrinking
            while (count == 0) {

                // Update minimum window
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }

                // Remove leftmost character
                char left = s.charAt(start);
                freq[left]++;

                // If a required character is removed, window becomes invalid
                if (freq[left] > 0) {
                    count++;
                }
                start++; // shrink window
            }
        }

        // Return result
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }

    // Main method for testing
    public static void main(String[] args) {

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1)); // Expected: BANC

        String s2 = "EFADOBEC";
        String t2 = "ABC";
        System.out.println(minWindow(s2, t2)); // Expected: ADOBEC

        String s3 = "a";
        String t3 = "a";
        System.out.println(minWindow(s3, t3)); // Expected: a

        String s4 = "a";
        String t4 = "aa";
        System.out.println(minWindow(s4, t4)); // Expected: ""
    }
}
