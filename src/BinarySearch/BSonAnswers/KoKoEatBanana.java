package BinarySearch.BSonAnswers;
/*
====================================================
LeetCode 875 : Koko Eating Bananas
====================================================

PROBLEM STATEMENT:
------------------
Koko loves bananas. There are n piles of bananas, the ith pile has nums[i] bananas.
Koko can eat at most k bananas per hour.

Each hour, she chooses ONE pile and eats up to k bananas from it.
If the pile has fewer than k bananas, she eats the entire pile.

Return the MINIMUM integer k such that she can eat all bananas within h hours.

----------------------------------------------------
APPROACH:
---------
Binary Search on Answer

Search Space:
- Minimum speed = 1
- Maximum speed = max(nums)

Condition:
- For a given speed k, compute total hours required:
  hours = sum of ceil(nums[i] / k)

This condition is monotonic:
- If k works, any speed > k also works
----------------------------------------------------
Time Complexity: O(n log max(nums))
Space Complexity: O(1)
====================================================
*/


public class KoKoEatBanana {

    public static int minEatingSpeed(int nums[],int h){
        int low =1;
        int high = 0;

        for(int num : nums){
            high = Math.max(num,high);
        }

        int ans = high;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(canComplete(nums,mid,h)){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }

    public static boolean canComplete(int []nums,int speed,int h){
        long hours = 0;

        for(int num : nums){
            hours+=(num+speed-1)/speed;
        }
        return hours<=h;
    }

    public static void main(String[] args) {

        int[] nums = {3, 11, 2, 4, 2};
        int h = 6;

        int result = minEatingSpeed(nums, h);

        System.out.println("Minimum Eating Speed: " + result);
    }}
