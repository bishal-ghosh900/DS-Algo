import java.util.*;

/**
 * Main1
 */
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {3,3,3,423,4,34,656,7,7,5,4,2,1,2,4,9};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,  int startIndex, int endIndex){
        
        if(startIndex > endIndex) return;
        int pivotIndex = findPivot(arr,  startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex + 1, endIndex);
        
    }

    public static int findPivot(int[] arr,  int startIndex, int endIndex){
        int pIndex = startIndex;
        int randomIndex = endIndex;
        for(int i = pIndex; i < endIndex; i++){
            if(arr[i] < arr[randomIndex]){
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = arr[randomIndex];
        arr[randomIndex] = temp;


        return pIndex;
    }
}