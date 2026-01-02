package SlidingWindow.Type1;

public class _0SkeletonCode {
        public int fixedSlidingWindow(int[] arr, int k) {
            int n = arr.length;

            // Edge case: if array size less than k
            if (n < k) {
                return -1; // or throw exception
            }

            // Step 1: Calculate result for FIRST window
            int windowResult = 0;
            for (int i = 0; i < k; i++) {
                windowResult += arr[i]; // or whatever operation
            }

            int maxResult = windowResult; // store first window result

            // Step 2: Slide the window from index k to n
            for (int i = k; i < n; i++) {
                // Remove element going out (left side)
                windowResult -= arr[i - k];

                // Add element coming in (right side)
                windowResult += arr[i];

                // Update result
                maxResult = Math.max(maxResult, windowResult);
            }

            return maxResult;
        }
}
//    Key Variables:
//
//        i = right end of window (new element index)
//        i - k = left end of window (element to remove)
//        windowResult = current window state (sum/count/etc)
//        maxResult = best result across all windows