package ArrayRotaion;

//Blockswap Algorithm
// -- Not a correct answer

import java.util.*;

public class Method4 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 9, 10, 12};

        int n = arr.length;
        
        int d = 5;

        rotateArray(arr, 0, n, d);
        System.out.println(Arrays.toString(arr));  
    }

    public static void rotateArray(int[] arr, int i, int n, int d) {
        if(d == n || d == 0){
            return;
        }

        if(d == n - d){
            swap(arr, i, n - d + i, d);
            return;
        }

        if(d < n - d){
            swap(arr, 0, n-d, d);
            rotateArray(arr, i, n-d+i, d);
        }
        else{
            swap(arr, 0, d, n - d);
            rotateArray(arr, n - d + i , d, n - d);
        }
    }

    public static void swap(int[] arr, int f, int l, int d){
        int temp;

        for(int i = 0; i < d; i++){
            temp = arr[f + i];
            arr[f + i] = arr[l + i];
            arr[l + i] = temp;
        }
    }
}
