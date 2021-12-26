import java.util.HashMap;


// ACODE - Alphacode
public class Main2 {

    static HashMap<Integer, Integer> DP = new HashMap<>();
    public static void main(String[] args) {
        int n = 1111111111;

        int comb = getAlphaCodeCombinations(n);
        System.out.println(comb);
    }

    private static int getAlphaCodeCombinations(int n) {
        
        if(n == 0){ 
            return 1;
        }
        if(n < 0){
            return 0;
        }
        
        if(DP.getOrDefault(n, -1) != -1){
            return DP.get(n);
        }
        
        int rightOne = n % 10;
        int rightTwo = n % 100;

        int c1 = 0, c2 = 0;
        if(rightOne >= 0 && rightOne <= 26){
            c1 = getAlphaCodeCombinations(n / 10);
        }
        if(rightTwo >= 0 && rightTwo <= 26){
            if(n < 10)
                c2 = getAlphaCodeCombinations(-1);
            else
                c2 = getAlphaCodeCombinations(n / 100);
        }

        DP.put(n, c1+c2);

        return DP.get(n);
    }
}
