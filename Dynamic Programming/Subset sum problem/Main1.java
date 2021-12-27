import java.util.*;

/**
 * Main1
 */
class SumLength{
    private Integer sum;
    private Integer length;

    SumLength(int sum, int length){
        this.sum = sum;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        SumLength res = (SumLength) obj;
        return sum.equals(res.sum) && length.equals(res.length) ? true : false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, length);
    }
}

public class Main1 {

    static Map<SumLength, Boolean> DP = new HashMap<>();
        public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9; 
        boolean isPossible = isSumPossible(arr, sum, arr.length); // true --> bcz (4, 5)
        System.out.println(isPossible);
    }

    private static boolean isSumPossible(int[] arr, int sum, int n) {

        if(sum == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(arr[n - 1] > sum) {
            return isSumPossible(arr, sum, n - 1);
        }

        SumLength sl = new SumLength(sum, n);

        if(DP.getOrDefault(sl, false) != false){
            return DP.get(sl);
        }

        DP.put(sl, isSumPossible(arr,sum - arr[n - 1] , n - 1) || isSumPossible(arr,sum , n - 1));

        return DP.get(sl);
    }
}