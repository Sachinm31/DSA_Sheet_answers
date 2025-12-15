package Arrays;

public class _1ArrayIsSorted {
    public static boolean sorted(int nums[]){
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int array[]={1,2,3,4,51,6};
        boolean ans = sorted(array);
        System.out.println(ans);
    }
}
