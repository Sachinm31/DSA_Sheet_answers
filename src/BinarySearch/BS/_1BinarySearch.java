package BinarySearch.BS;

public class _1BinarySearch {
    public static int search(int[] nums,int target){
        int n = nums.length;
        int start = 0;
        int end =n-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target==nums[mid]){
                return mid;
            } else if (target>nums[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        int target = 7;
        int ans = search(nums,target);
        System.out.println(ans);
    }
}
