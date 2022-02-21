import java.util.Arrays;

public class Main1{
    public static void main(String[] args){

        int[] arr = {5, 4, 3, 2, 1};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort (int[] arr, int n) {
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }

            if(count == 0){
                break;
            }
        }
    }
}