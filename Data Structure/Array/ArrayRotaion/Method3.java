package ArrayRotaion;

//Revarsal Algorithm

import java.util.Arrays;

public class Method3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int n = arr.length;

        rotateArray(arr, n, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int n, int d) {

        if(d == 0){
            return;
        }        

        d = d % n;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);

    }

    public static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while(start <= end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
