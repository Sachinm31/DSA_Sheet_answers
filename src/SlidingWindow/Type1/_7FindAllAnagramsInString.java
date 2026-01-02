package SlidingWindow.Type1;

import java.util.*;

/*
Problem Statement:
Given two strings s and p, return a list of all start indices of p's anagrams in s.

An anagram is a permutation of a string that uses the same characters
with the same frequencies, but possibly in a different order.

Example:
Input:  s = "cbaebabacd"
        p = "abc"
Output: [0, 6]

Explanation:
The substrings "cba" (index 0) and "bac" (index 6) are anagrams of "abc".

Constraints:
- 1 <= s.length, p.length <= 10^4
- s and p consist of lowercase English letters
*/

public class _7FindAllAnagramsInString {

    // Fixed Size Sliding Window
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int len2 = s.length();
        int len1 = p.length();

        // Edge case
        if (len1 > len2) return res;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of p
        for (int i = 0; i < len1; i++) {
            freq1[p.charAt(i) - 'a']++;
        }

        // First window of s
        for (int i = 0; i < len1; i++) {
            freq2[s.charAt(i) - 'a']++;
        }

        if (matches(freq1, freq2)) {
            res.add(0);
        }

        // Slide the window
        for (int i = len1; i < len2; i++) {
            freq2[s.charAt(i - len1) - 'a']--; // remove left
            freq2[s.charAt(i) - 'a']++;        // add right

            if (matches(freq1, freq2)) {
                res.add(i - len1 + 1);
            }
        }

        return res;
    }

    // Helper method to compare frequency arrays
    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);
        System.out.println("Anagram starting indices: " + result);
    }
}
