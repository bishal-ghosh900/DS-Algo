/**
 * Main1
 */
import java.util.*;
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 12};
        int minimum = Arrays.stream(arr).min().getAsInt();
        int[] promises = new int[5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < arr.length ; j++){
                int diff = arr[j] - minimum;
                int steps = (diff / 5) + ((diff % 5) / 2) + (((diff % 5) % 2) / 1) ;
                promises[i] += steps;
            }
            minimum--;
        }

        int res = Arrays.stream(promises).min().getAsInt();
        System.out.println(res);
    }
}