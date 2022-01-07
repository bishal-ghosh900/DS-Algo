import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Main1
 */
public class Main1 {

    public static void main(String[] args) {
        int[] arr = { -1, -1, -2, 4, 3 };
        // int[] arr = {2, 2};

        int quantityOfNegativeElements = (int)Arrays.stream(arr).filter(i -> i < 0).count();

        int ans = 0;

        if(arr.length == 1){
            ans = arr[0];
        }
        else if(quantityOfNegativeElements == 0){
            ans = Arrays.stream(arr).filter(i -> i != 0).reduce((a, b) -> a * b).orElse(0) ;            
        }
        else {
            if(quantityOfNegativeElements % 2 == 0){
                ans = Arrays.stream(arr).filter(i -> i != 0).reduce(1, (a, b) -> a * b);
            } else {
                int largestNegative = Arrays.stream(arr).filter(i -> i < 0).max().getAsInt();
                if(arr.length == 2){
                    ans = Arrays.stream(arr).filter(i -> i != largestNegative).toArray()[0];
                }else {

                    int index = IntStream.range(0, arr.length).filter(i -> largestNegative == arr[i]).findFirst().orElse(-1);
                    arr[index] = 0;
                    ans = Arrays.stream(arr).filter(i -> i != 0).reduce(1, (a,b) -> a * b);
                }
            }
        }
        System.out.println(ans);
    }
}