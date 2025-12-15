package Arrays.Sorting;

public class BubbleSort {
        public static void BubbleSort(int arr[]){
            int n  = arr.length;

            for(int i = 0;i<n-1;i++){
                boolean swapped = false;

                for(int j = 0;j<n-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        int temp = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]= temp;
                        swapped = true;
                    }

                }
                if(!swapped) break;
            }

        }
    public static void print(int arr[]){
        for(int i : arr){
            System.out.print(i +"-->");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,1,2,6,4,0};

        BubbleSort(arr);
        print(arr);
    }
}
