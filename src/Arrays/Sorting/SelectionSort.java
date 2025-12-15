package Arrays.Sorting;
//Concept
//
//        You select the smallest element from the unsorted part
//        and put it in its correct position at the beginning.
//
//        👉 First position → find smallest of entire array
//        👉 Second position → find smallest of remaining elements
//        👉 And so on…
public class SelectionSort {
    public static void Selection(int arr[]){
        int n = arr.length;

        for(int i =0;i<n-1 ;i++){
            int minIndex = i;

            for(int j =i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    public static void print(int arr[]){
        for(int i : arr){
            System.out.print(i +"-->");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,1,2,6,4,0};

        Selection(arr);
        print(arr);
    }
}
