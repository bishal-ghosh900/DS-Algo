package ArrayRotaion;

//Straightforward way


import java.util.Arrays;

/**
 * ArrayRotation
 */

//Method - 1 : 
public class Method1 {

    public static void rotateArray(int[] arr, int n, int d){
        
        for(int i = 0 ; i < d ; i++){
            int temp = arr[0];
            for(int j = 0; j < n - 1 ; j++){
                arr[j] = arr[j+1];
            }

            arr[n-1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int n = arr.length;

        rotateArray(arr, n, 2);
        System.out.println(Arrays.toString(arr));
    }
}