package BinarySearch.BS;

public class _6FreqOfNumberInSortedArray {

        public static int countFreq(int[] nums, int target) {
            // code here
            int first = findFirst(nums,target);
            int second = findSecond(nums,target);
            if(first==-1) return 0;
//        count occurances
            return (second-first+1);

        }
        public static int findFirst(int nums[],int target){
            int ans = -1;
            int start = 0;
            int end = nums.length-1;

            while(start<=end){
                int mid = start+(end-start)/2;

                if(target==nums[mid]){
                    end=mid-1;
                    ans=mid;
                }else if(target<nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            return ans;
        }
        public static int findSecond(int nums[],int target){
            int ans = -1;
            int start = 0;
            int end = nums.length-1;

            while(start<=end){
                int mid = start+(end-start)/2;

                if(target==nums[mid]){
                    start=mid+1;
                    ans=mid;
                }else if(target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            return ans;

        }

    public static void main(String[] args) {
        int nums[]={1,2,2,2,2,2,3,3,3,3,4,4,5,6,7,8};
        int ans1 = countFreq(nums,3);
        int ans2 = countFreq(nums,2);
        int ans3 = countFreq(nums,4);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }

}
