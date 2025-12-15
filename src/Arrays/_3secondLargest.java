package Arrays;

public class _3secondLargest {
    public static int secondLargestElement(int[] nums) {
        int large = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > large) {
                second = large;
                large = num;
            } else if (num < large && num > second) {
                second = num;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int arr[] = {12,5,4,11,2,1};
        int ans = secondLargestElement(arr);
        System.out.println(ans);
    }
}
