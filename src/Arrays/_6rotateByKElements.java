package Arrays;

public class _6rotateByKElements {
    public static void rotate(int nums[],int k){
        int n = nums.length;
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);

    }
    public static void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[]= {1,2,3,4,5,6,7,8,9};
        System.out.println("before:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        int k = 3;
        rotate(nums,k);
        System.out.println("after:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }

    }
}
