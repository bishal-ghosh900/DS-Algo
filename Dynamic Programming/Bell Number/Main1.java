import java.util.Arrays;

import javax.swing.text.html.parser.Element;

// To find bell(n) , bell triangle is best to use.
/**
 * 1
 * 1 2
 * 2 3 5
 * 5 7 10 15
 */


public class Main1 {
    public static void main(String[] args) {
        int n = 3;

        int[][] arr = new int[n+1][n+1];
        for (int[] is : arr) {
            Arrays.setAll(is, i -> 0);
        }
        arr[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    arr[i][j]= arr[i-1][i-1];
                }
                else {
                    arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
                }
            }
        }

        System.out.println(arr[n][0]);

    }
}