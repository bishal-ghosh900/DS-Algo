import java.util.*;

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = { 3, 67, 3, 5, 3, 2, 7, 9, 3 };
        int n = arr.length;
        mergeSort(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int n) {

        if(n < 2){
            return;
        }

        int mid = n / 2;

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        int lc = 0, rc = 0;

        for (int i = 0; i < mid; i++) {
            left[lc++] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[rc++] = arr[i];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(left, right, arr);

    }

    public static void merge(int[] left, int[] right, int[] arr) {

        int i = 0;
        int j = 0;
        int k = 0;
        int nL = left.length;
        int nR = right.length;
        while (i < nL && j < nR) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
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
        while(j < nR){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
