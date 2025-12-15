package Arrays;

public class _5moveZerosLast {
    public static void moveZeros(int nums[]){
        int insert = 0;
        for(int num:nums){
            if(num!=0){
                nums[insert]=num;
                insert++;
            }

        }
        while(insert<nums.length){
            nums[insert]=0;
            insert++;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,2,0,3,4,0,5};
        moveZeros(nums);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
            if(i!=nums.length-1){
                System.out.print(",");
            }
        }
    }
}
