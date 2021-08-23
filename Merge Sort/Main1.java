import java.util.*;

/**
 * Main1
 */
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;

        mergeSort(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int n){

        if(n < 2){
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        int p = 0, q = 0;
        for(int i = 0; i < mid; i++){
            left[p++] = arr[i];
        }
        for(int i = mid; i < n; i++){
            right[q++] = arr[i];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr){
        int nL = left.length;
        int rL = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nL && j < rL){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < nL){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < rL){
            arr[k] = right[j];
            j++;
            k++;
        }

    }
}