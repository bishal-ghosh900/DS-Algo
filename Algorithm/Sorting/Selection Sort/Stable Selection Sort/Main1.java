import java.util.Arrays;

// Its just a stable version of selection sort , means it will keep its order same if the two key are of same value. 

// Algo --> Every time after selcting the minimum key (using select() method) we need to push the elements to the right side and place that minimum key in the correct place. Here after finding the minimum key index,  in pushElement method  we are replacing that key with the immediate left key and we are doing this till the place where the minimum key should be placed.

public class Main1{
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 9, 5, 2, 6, 1};

        int n = arr.length;

        stableSelectionSort(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    public static void stableSelectionSort(int[] arr, int n){
        for(int i = 0; i < n; i++){
            int minIndex = select(arr, n, i);
            pushElements(arr, minIndex, n, i);
        }
    }

    public static void pushElements(int[] arr, int minIndex, int n, int i){
        for(int j = minIndex; j > i; j--){
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
        }
    }

    public static int select(int[] arr, int n, int i){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int j = i; j < n; j++){
            if(arr[j] < min){
                min = arr[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
}