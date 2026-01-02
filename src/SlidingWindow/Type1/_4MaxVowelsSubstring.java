package SlidingWindow.Type1;

/*
Problem Statement:
Given a string s and an integer k, return the maximum number of vowel letters
in any substring of s with length k.

Vowels are 'a', 'e', 'i', 'o', and 'u'.

Example:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" has 3 vowels.

Constraints:
- 1 <= s.length <= 10^5
- s consists of lowercase English letters
- 1 <= k <= s.length
*/

public class _4MaxVowelsSubstring {

    // Fixed Size Sliding Window
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int maxCount = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove left character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            // Add right character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Helper method to check vowel
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Main method for testing
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        int result = maxVowels(s, k);
        System.out.println("Maximum number of vowels in a substring of length "
                + k + " is: " + result);
    }
}
