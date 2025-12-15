package Arrays;

public class _4RemoveDupFrmSortedArray {
    public static int remove(int nums[]){
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j]
;            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,2,3,4,5,6,7,7,8};
        int ans = remove(nums);
        System.out.println(ans);
    }
}
