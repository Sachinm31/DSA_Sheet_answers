package Sorting;
//Insertion sort works exactly like how you arrange playing cards in your hand:
//
//        You take one card at a time
//
//        Compare it with cards on your left
//
//        Shift bigger cards to the right
//
//        Insert your card in the correct position
//
//        Same logic for array:
//
//        👉 Left side of array = always sorted
//        👉 Right side = unsorted
//        👉 Pick one element from right and insert into correct place in sorted left part
public class insertionSort {
    public static void insertion(int arr[]){
        int n=arr.length;

        for(int i =1;i<n;i++){
            int key = arr[i];

            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void print(int arr[]){
        for(int i : arr){
            System.out.print(i +"-->");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,1,2,6,4,0};

        insertion(arr);
        print(arr);
    }
}
