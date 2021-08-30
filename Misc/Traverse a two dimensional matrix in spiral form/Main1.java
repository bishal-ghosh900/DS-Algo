import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        int count = 97;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = (char)count++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        traverseSpirally(arr, n);
        sc.close();
    }

    public static void traverseSpirally(char[][] arr, int n){

        /*
        a b c d 
        e f g h
        i j k l
        m n o p
        */
        int rows = 0;
        int cols = 0;
        int rightCols = n - 1;
        int leftCols = 0;
        int downRows = n - 1;
        int upRows = 1;
        int counting = (n%2 == 0) ? n / 2 : (n/2) + 1;
        while(counting-- > 0){
            for(int i = cols; i <= rightCols; i++){
                System.out.print(arr[rows][i] + " ");
                cols = i;
            }
            rows++;
            for(int j = rows; j <= downRows; j++){
                System.out.print(arr[j][cols] + " ");
                rows = j;
            }
            cols--;
            for(int k = cols; k >= leftCols; k--){
                System.out.print(arr[rows][k] + " ");
                cols = k;
            }
            rows--;
            for(int l = rows; l >= upRows; l--){
                System.out.print(arr[l][cols] + " ");
                rows = l;
            }
            cols++;

            rightCols--;
            leftCols++;
            downRows--;
            upRows++;
        }
    }
}