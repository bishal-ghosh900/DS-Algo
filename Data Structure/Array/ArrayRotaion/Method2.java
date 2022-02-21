package ArrayRotaion;

//By java library function

import java.util.Arrays;

/**
 * ArrayRotation
 */

//Method - 1 : 
public class Method2 {

    public static int[] rotateArray(int[] arr, int n, int d){
        
        int[] arr1 = Arrays.copyOfRange(arr, 0, d);
        int[] arr2 = Arrays.copyOfRange(arr, d, n);
        int result[] = new int[n];
        System.arraycopy(arr2, 0, result, 0, arr2.length);
        System.arraycopy(arr1, 0, result, arr2.length, arr1.length);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int n = arr.length;

        
        System.out.println(Arrays.toString(rotateArray(arr, n, 3)));
    }
}