
import java.util.TreeSet;

/**
 * Main1
 */
// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 22
 // Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
 // The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included
public class Main1 {

    public static void main(String[] args) {
        int n = 15;
        int res = getUglyNumber(n);
        System.out.println(res);
    }

    private static int getUglyNumber(int n) {
        TreeSet<Integer> q = new TreeSet<>(); // We can't choose priority queue as priority queue don't block duplicate values.  
        q.add(1);
        int i = 1;
        while(i < n){
            int temp = q.pollFirst();
            q.add(temp * 2);
            q.add(temp * 3);
            q.add(temp * 5);
            i++;
        }

        return q.pollFirst();
    }
}