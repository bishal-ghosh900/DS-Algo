import java.time.Duration;
import java.time.Instant;
import java.util.*;

// Bytelandian gold coin

class Main1 {

    static HashMap<Long, Long> DP = new HashMap<>();


    public static void main(String[] args) {
        long n = 605546394;
        Instant instant1 = Instant.now();
        long dollar = getDollars(n);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(dollar);
        System.out.println(
            duration.toMillis()+""
        );
    }

    static long getDollars(long n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){ 
            return 1;
        }

        if(DP.getOrDefault(n, (long) -1) != -1){
            return Math.max(n, DP.get(n));
        }
        DP.put(n,getDollars(n/2) + getDollars(n/3) + getDollars(n/4)) ;

        return Math.max(n, DP.get(n));
    }
}