package Arrays;

public class _2ArraySortedRotated {
    public static boolean sortedRotated(int nums[]){
        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
        }
        return count<=1;
    }
    public static void main(String[] args) {
        int array[]={3,4,5,6,1,2};
        boolean ans = sortedRotated(array);
        System.out.println(ans);
    }
}
