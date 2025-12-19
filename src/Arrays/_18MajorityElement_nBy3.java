package Arrays;

import java.util.ArrayList;
/*
 INTERVIEW EXPLANATION – MAJORITY ELEMENT (> n/3)

 Problem:
 Find all elements that appear more than ⌊n/3⌋ times in an array.

 Key Insight:
 At most two elements can satisfy this condition.
 If three elements appeared more than n/3 times, total frequency would exceed n.

 Approach: Extended Boyer–Moore Voting Algorithm

 Step 1: Candidate Selection
 - Maintain two candidates (cand1, cand2) and their counts.
 - Traverse the array:
     • If current element matches a candidate, increment its count.
     • If a candidate’s count becomes zero, replace it with current element.
     • Otherwise, decrement both counts (cancels out less frequent elements).

 Step 2: Verification
 - Reset counts and count actual occurrences of both candidates.
 - Add a candidate to result only if its count > n/3.

 Why it works:
 - Non-frequent elements get cancelled out.
 - Only elements with high frequency survive the voting process.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class _18MajorityElement_nBy3 {
    public static ArrayList<Integer>Majority(int nums[]){
        int n = nums.length;
        int cand1=0;
        int cand2 = 0;
        int count1=0;
        int count2=0;

        for(int num:nums){
            if(num==cand1){
                count1++;
            }else if (num==cand2){
                count2++;
            } else if (count1==0) {
                cand1 = num;
                count1=1;
            } else if (count2==0) {
                cand2=num;
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }
        count2=0;
        count1=0;
        ArrayList<Integer>list = new ArrayList<>();
        for(int num:nums){
            if (num==cand1){
                count1++;
            }else if (num==cand2){
                count2++;
            }
        }
        if (count1>n/3) list.add(cand1);
        if(count2>n/3) list.add(cand2);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 3, 2, 2, 2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3};

        ArrayList<Integer> result = Majority(nums);

        System.out.println("Majority elements (> n/3): " + result);
    }
}