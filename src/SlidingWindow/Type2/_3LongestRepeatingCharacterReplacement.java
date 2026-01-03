package SlidingWindow.Type2;

/*
 PROBLEM STATEMENT (LeetCode 424):
 --------------------------------
 You are given a string s consisting of only uppercase English letters
 and an integer k.

 You can replace at most k characters in the string with any other
 uppercase English letter.

 Return the length of the longest substring that can be made to contain
 the same character after performing at most k replacements.

 Example:
 Input:  s = "AABABBA", k = 1
 Output: 4
 Explanation:
 Replace the one 'B' in "AABA" or "ABBA" to get a substring of length 4
 with all identical characters.

 TECHNIQUE USED:
 ----------------
 Sliding Window + Frequency Array

 KEY LOGIC:
 ----------
 windowSize - maxFrequency <= k

 TIME COMPLEXITY:
 ----------------
 O(n)

 SPACE COMPLEXITY:
 -----------------
 O(26) ≈ O(1)
*/

public class _3LongestRepeatingCharacterReplacement {

    // -------- STATIC METHOD --------
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            // If replacements needed > k, shrink window
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        String s1 = "AABABBA";
        int k1 = 1;

        String s2 = "ABAB";
        int k2 = 2;

        String s3 = "AAAA";
        int k3 = 0;

        System.out.println(characterReplacement(s1, k1)); // 4
        System.out.println(characterReplacement(s2, k2)); // 4
        System.out.println(characterReplacement(s3, k3)); // 4
    }
}
