import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr1 = new int[n][n];
        int[][] arr2 = new int[n][n];
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        
        
        
        int res[][] = doMatrixMultiplication(arr1, arr2, n);
        System.out.println("----------------------------------");
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        

        sc.close();
    }

    public static int[][] doMatrixMultiplication(int[][] arr1, int[][] arr2, int n){
        int[][] res = new int[n][n];
        int sum = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i = 0; i < n; i++){
            count1 = n;
            count2 = 0;
            while(count1-- > 0){
                sum = 0;
                for(int j = 0; j < n; j++){

                    sum += arr1[i][j] * arr2[j][count2];
                }
                count2++;
                res[i][count3++] = sum;
            }
            count3 = 0;
            
        }

        return res;
    }
}