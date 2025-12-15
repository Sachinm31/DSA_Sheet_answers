package matrix;

//arr     = [3, 0, 4, 1, 2]
//index   =  0  1  2  3  4
//
//        Inverse logic:
//        inverse[3] = 0
//        inverse[0] = 1
//        inverse[4] = 2
//        inverse[1] = 3
//        inverse[2] = 4
//
//        inverse = [1, 3, 4, 0, 2]
public class InverseOfArray {
    public static int[] inverse(int arr[]){
        int inv[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            int val = arr[i];
            inv[val] = i;
        }
        return inv;
    }
    public static void main(String args[]) {
        int[] arr = {3, 0, 4, 1, 2};

        int[] inv = inverse(arr);

        System.out.print("Inverse array: ");
        for (int x : inv) {
            System.out.print(x + " ");
        }
    }

}
