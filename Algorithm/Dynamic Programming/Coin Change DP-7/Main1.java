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

    static HashMap<SumLength, Integer> DP = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 9, 11, 12, 13, 15};
        int sum = 8;
        int combs = getCoinChangeCombination(arr, sum, arr.length);
        System.out.println(combs);
    }
    private static int getCoinChangeCombination(int[] arr, int sum, int n) {
        
        if(sum == 0){
            return 1;
        }
        
        if(sum < 0){
            return 0;
        }
        
        if(n == 0){
            return 0;
        }
        
        SumLength sl = new SumLength(sum, n);

        if(DP.getOrDefault(sl, -1) != -1){
            return DP.get(sl);
        }

        DP.put(sl, getCoinChangeCombination(arr, sum - arr[n-1], n) + getCoinChangeCombination(arr, sum, n - 1));

        return DP.get(sl);
    }
}