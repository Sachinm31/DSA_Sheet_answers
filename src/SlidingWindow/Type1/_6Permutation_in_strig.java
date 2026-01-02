package SlidingWindow.Type1;

/*
Problem Statement:
Given two strings s1 and s2, return true if s2 contains a permutation
of s1, otherwise return false.

A permutation of a string is another string that contains the same
characters with the same frequencies, but possibly in a different order.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains "ba", which is a permutation of s1.

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
- 1 <= s1.length, s2.length <= 10^4
- s1 and s2 consist of lowercase English letters only
*/

public class _6Permutation_in_strig {

    // Fixed Size Sliding Window
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Edge case
        if (len1 > len2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of s1
        for (int i = 0; i < len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        // First window of s2
        for (int i = 0; i < len1; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freq1, freq2)) return true;

        // Slide the window
        for (int i = len1; i < len2; i++) {
            freq2[s2.charAt(i - len1) - 'a']--; // remove left
            freq2[s2.charAt(i) - 'a']++;        // add right

            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    // Helper method to compare frequency arrays
    public static boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);
        System.out.println("Permutation exists: " + result);
    }
}
