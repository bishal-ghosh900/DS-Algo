import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,423,4,34,656,7,7,5,4,2,1,2,4,9};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex > endIndex) return; 

        int pivot = findRandomPivot(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivot - 1);
        quickSort(arr, pivot + 1, endIndex);
    }

    private static int findRandomPivot(int[] arr, int startIndex, int endIndex){
        int randomIndex = (int)(Math.random() * (endIndex - startIndex + 1)) + startIndex;
        swap(arr, randomIndex, endIndex);
        return findPivot(arr, startIndex, endIndex);
    }

    private static int findPivot(int[] arr, int startIndex, int endIndex){
        int pivot = startIndex;
        int lastIndex = endIndex;
        for(int i = startIndex; i < endIndex; i++){
            if(arr[i] < arr[lastIndex]){
                swap(arr, i, pivot);
                pivot++;
            }
        }
        swap(arr, pivot, lastIndex);
        return pivot;
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}
