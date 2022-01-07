import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Main1
 */
public class Main1 {
    public static void main(String[] args) {
        // int[] arr = { -1, -1, -2, 4, 3 };
        int[] arr = {-3, -2, -2, -2, 7 };

        int quantityOfNegativeElements = (int)Arrays.stream(arr).filter(v -> v < 0).count();

        int ans = 0;

        if(quantityOfNegativeElements == 0){
            if(Arrays.stream(arr).anyMatch(i -> i == 0))
                ans = 0;
            else
                ans = Arrays.stream(arr).min().getAsInt();
        } else {
            if(quantityOfNegativeElements % 2 != 0){
                ans = Arrays.stream(arr).filter(i -> i != 0).reduce(1, (a, b) -> a * b);
            } else {
                int largestNegative = Arrays.stream(arr).filter(i -> i < 0).max().getAsInt();
                int index = IntStream.range(0, arr.length)
                                     .filter(i -> largestNegative == arr[i])
                                     .findFirst()
                                     .orElse(-1);
                arr[index] = 0;
                ans = Arrays.stream(arr).filter(i -> i != 0).reduce(1, (a, b) -> a * b);
            }
        }

        System.out.println(ans);
    }
}