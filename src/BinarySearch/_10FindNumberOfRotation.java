package BinarySearch;

public class _10FindNumberOfRotation {
    public static int NoOfRotation(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Binary Search
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // Minimum lies in left half (including mid)
            else {
                end = mid;
            }
        }
        // start == end → minimum element
        return start;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum element: " + NoOfRotation(nums1)); // 0
        System.out.println("Minimum element: " + NoOfRotation(nums2)); // 1
        System.out.println("Minimum element: " + NoOfRotation(nums3)); // 11
    }
}
