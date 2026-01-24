package Strings;

public class _1FirstUniqueCharacter {
    // static method as per interview & LeetCode style
    public static int firstUniqChar(String s) {

        // Step 1: Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Step 2: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 3: Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i; // return index
            }
        }

        // Step 4: If no unique character
        return -1;
    }

    // main method for local testing
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(firstUniqChar(s1)); // 0
        System.out.println(firstUniqChar(s2)); // 2
        System.out.println(firstUniqChar(s3)); // -1
    }
}
