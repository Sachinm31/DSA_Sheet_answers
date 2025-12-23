package BinarySearch.BS;

public class _3ceil {
    /**
     * Problem:
     * Given a sorted array arr[] and a value x,
     * find the index of the smallest element in arr[]
     * that is greater than or equal to x (Ceil of x).
     * If no such element exists, return -1.
     */
    public static int findCeil(int[] arr, int x) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // If x is greater than the largest element,
        // ceil does not exist
        if (x > arr[n - 1]) {
            return -1;
        }

        // Binary Search
        while (start <= end) {

            // Avoid overflow
            int mid = start + (end - start) / 2;

            // If x is greater, move right
            if (x > arr[mid]) {
                start = mid + 1;
            }
            // Possible ceil found, move left to find smaller index
            else {
                end = mid - 1;
            }
        }

        // start points to the ceil index
        return start;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {



        int[] arr = {1, 2, 8, 10, 10, 12, 19};

        int x1 = 5;
        int x2 = 10;
        int x3 = 20;

        System.out.println("Ceil index of " + x1 + " = " + findCeil(arr, x1)); // 2
        System.out.println("Ceil index of " + x2 + " = " + findCeil(arr, x2)); // 3
        System.out.println("Ceil index of " + x3 + " = " + findCeil(arr, x3)); // -1
    }
}
