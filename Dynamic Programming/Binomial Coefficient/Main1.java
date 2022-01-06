/**
 * Main1
 */
import java.util.*;
public class Main1 {

    final static int mod = 1000000007;
    public static void main(String[] args) {
        int n = 15;
        int r = 3;
        int[][] list = new int[n+1][r+1];

        // one way
        for (int[] is : list) {
            Arrays.setAll(is, i -> -1);
        }
        System.out.println(nCr1(n, r, list));

        // another way
        System.out.println(nCr2(n, r));
    }

    // one way
    static int nCr1(int n, int r, int[][] list){
        if(r > n) return 0;
        if(r > n - r) r = n-r;
        if(r == n || r == 1) return n;
        if(r == 0) return 1;
        if(list[n][r] != -1){
            return list[n][r];
        }
        list[n][r] = (nCr1(n-1, r - 1, list) + nCr1(n-1, r, list)) % mod;
        
        return list[n][r];
    }
    
    //another way
    static int nCr2(int n, int r) {
        if(r > n) return 0;
        if(r > n - r) r = n-r;
        if(r == n || r == 1) return n;
        if(r == 0) return 1; 

        int[][] arr = new int[n+1][r+1];

        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <=Math.min(i, r); j++)
            {
                if(j == 0) arr[i][j] = 1;
                else arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % mod;
            }
        }

        return arr[n][r];
    }
}