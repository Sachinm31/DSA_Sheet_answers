package Arrays;

public class _14KadanesAlgo {
    public static int maxSum(int nums[]){
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num:nums){
            sum+=num;
            maxSum=Math.max(sum,maxSum);
            sum=sum<0?0:sum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-5, -2, -8, -1};
        int[] nums3 = {1, 2, 3, 4};

        System.out.println(maxSum(nums1)); // 6
        System.out.println(maxSum(nums2)); // -1
        System.out.println(maxSum(nums3)); // 10
    }
}
