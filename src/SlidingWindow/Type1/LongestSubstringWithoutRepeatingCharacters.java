package SlidingWindow.Type1;

import java.util.HashMap;
/**
 * Problem: Longest Substring Without Repeating Characters (LeetCode 3)
 *
 * Goal:
 * Find the maximum length of a substring without repeated characters.
 *
 * Approach: Sliding Window + HashMap (Frequency Check)
 *
 * 1️⃣ Expand window by moving 'end' pointer and count frequency of characters
 * 2️⃣ If a character repeats (freq > 1), shrink from the left until valid
 * 3️⃣ Validate window where every char appears only once
 * 4️⃣ Update max length each time window is valid
 *
 * Time: O(n) — each character added and removed at most once
 * Space: O(256) or O(k) unique characters
 */
//    s = "abcabcbb"
//    Longest = "abc"
//    Answer = 3

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubString(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int n = str.length();

        for(int end=0;end<n;end++){
            char ch = str.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>=2){
                char left = str.charAt(start);
                map.put(left,map.get(left)-1);
                start++;
            }
            maxLen=Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcabcdxyzabc";
        int ans = longestSubString(s);
        System.out.println(ans);
    }
}
