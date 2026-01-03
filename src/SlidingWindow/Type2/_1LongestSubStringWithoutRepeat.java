package SlidingWindow.Type2;

import java.util.HashMap;

/*
 PROBLEM STATEMENT:
 ------------------
 Given a string s, find the length of the longest substring
 without repeating characters.

 Example:
 Input:  "abcabcbb"
 Output: 3
 Explanation: "abc" is the longest substring without repetition.

 TECHNIQUE USED:
 ----------------
 Sliding Window + HashMap (Last Seen Index)

 KEY IDEA:
 ----------
 - Use two pointers (start, end) to represent a window
 - Store the last index of each character
 - If a duplicate appears, jump 'start' to
   max(start, lastIndex + 1) to avoid moving backward

 TIME COMPLEXITY:
 ----------------
 O(n) — each character is processed once

 SPACE COMPLEXITY:
 -----------------
 O(min(n, charset))
*/

public class _1LongestSubStringWithoutRepeat {

    // ---------- STATIC METHOD ----------
    public static int lengthOfLongestSubstring(String s) {


        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxLen = 0;

        // for(int end=0;end<n;end++){
        //     char right = s.charAt(end);
        //     map.put(right,map.getOrDefault(right,0)+1);

        //     while(map.get(s.charAt(end))>1){
        //         char leftChar = s.charAt(start);
        //         map.put(leftChar,map.get(leftChar)-1);
        //         start++;
        //     }

        //     len = Math.max(len,end-start+1);
        // }

        for (int end = 0; end < n; end++) {
            char right = s.charAt(end);

            // If character already seen, move start pointer safely
            if (map.containsKey(right)) {
                start = Math.max(start, map.get(right) + 1);
            }

            // Update last seen index
            map.put(right, end);

            // Update maximum length
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "abba";

        System.out.println(lengthOfLongestSubstring(s1)); // 3
        System.out.println(lengthOfLongestSubstring(s2)); // 1
        System.out.println(lengthOfLongestSubstring(s3)); // 3
        System.out.println(lengthOfLongestSubstring(s4)); // 2
    }
}
