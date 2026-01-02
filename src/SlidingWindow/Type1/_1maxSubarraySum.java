package SlidingWindow.Type1;

public class _1maxSubarraySum {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        if(k>arr.length) return -1;

        int maxSum = 0;
        int sum = 0;

        for(int i = 0;i<k;i++){
            sum+=arr[i];
        }
        maxSum = sum;

        for(int i = k;i<arr.length;i++){
            sum-=arr[i-k];
            sum+=arr[i];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
