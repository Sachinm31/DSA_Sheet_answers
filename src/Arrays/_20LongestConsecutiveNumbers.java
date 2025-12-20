package Arrays;
//Input:  nums = [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: Longest consecutive sequence is [1, 2, 3, 4]

import java.util.HashSet;

public class _20LongestConsecutiveNumbers {
    public static int longestConsecutive(int[] nums){
        int count = 0;
        int maxLen = 0;
        int currentNum = 0;
        HashSet<Integer>set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                currentNum=num;
                count=1;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    count++;
                }
                maxLen= Math.max(maxLen,count);
            }

        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
