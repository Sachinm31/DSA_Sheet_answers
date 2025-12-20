package BinarySearch;

public class _4Floor {
    /**
     * Finds the index of the floor of x in a sorted array.
     * Floor = largest element <= x
     *
     * @param arr sorted integer array
     * @param x   target value
     * @return index of floor element, or -1 if not found
     */
    public static int findFloor(int[] arr, int x) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // If x is smaller than the smallest element,
        // floor does not exist
        if (x < arr[0]) {
            return -1;
        }

        // Binary Search
        while (start <= end) {

            // Prevent integer overflow
            int mid = start + (end - start) / 2;

            // Possible floor found, move right to find bigger value
            if (x >= arr[mid]) {
                start = mid + 1;
            }
            // Value too large, move left
            else {
                end = mid - 1;
            }
        }

        // end points to the index of floor element
        return end;
    }

    // 🔹 Main method
    public static void main(String[] args) {

        int[] arr = {1, 2, 8, 10, 10, 12, 19};

        int x1 = 9;
        int x2 = 10;
        int x3 = 0;

        System.out.println("Floor index of " + x1 + " = " + findFloor(arr, x1)); // 2
        System.out.println("Floor index of " + x2 + " = " + findFloor(arr, x2)); // 4
        System.out.println("Floor index of " + x3 + " = " + findFloor(arr, x3)); // -1
    }
}
