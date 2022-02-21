import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        int n = arr.length;
        selectionSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int n) {
        
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}