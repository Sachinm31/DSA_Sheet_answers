package Arrays;

public class _15KadanesAlgo2 {
    public static void maxSumSubarray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;      // temporary start
        int ansStart = 0;   // final start
        int ansEnd = 0;     // final end

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Update maxSum and indices
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Reset if sum becomes negative
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        // Print result
        System.out.println("Maximum Sum = " + maxSum);
        System.out.print("Subarray = ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSumSubarray(nums);
    }
}
