import java.util.*;

// Coin Change 

// Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
// For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

public class Main1
{
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size]; 
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
	    int n = sc.nextInt();
	    
	    
	    int[][] m = new int[arr.length][n+1];
	    
	    for(int i = 0; i < arr.length; i++){
	        m[i][0] = 1;
	    }
	    
	    for(int i = 0; i < 1; i++){
	        for(int j = 1; j <= n; j++){
	            if(arr[i] > j){
	                m[i][j] = 0;
	            }
	            else{
	                if(j%arr[i] == 0){
	                    m[i][j] = 1;
	                }
	                else{
	                    m[i][j] = 0;
	                }
	            }
	        }
	    }
	    
	    for(int i = 1; i < arr.length; i++){
	        for(int j = 1; j <= n; j++){
	            if(arr[i] > j){
	                m[i][j] = m[i-1][j];
	                
	            }
	            else{
	                m[i][j] = m[i-1][j]+m[i][j - arr[i]];
	                
	            }
	        }
	    }
	    
	    
		System.out.println(m[arr.length-1][n]);
        sc.close();
	}
}
