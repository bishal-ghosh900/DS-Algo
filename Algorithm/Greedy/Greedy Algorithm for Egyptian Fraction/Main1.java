/**
Greedy Algorithm for Egyptian Fraction -->
Difficulty Level : Medium

Every positive fraction can be represented as sum of unique unit fractions. A fraction is unit fraction if numerator is 1 and denominator is a positive integer, for example 1/3 is a unit fraction. Such a representation is called Egyptian Fraction as it was used by ancient Egyptians. 
Following are few examples: 
 

Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
Egyptian Fraction Representation of 6/14 is 1/3 + 1/11 + 1/231
Egyptian Fraction Representation of 12/13 is 1/2 + 1/3 + 1/12 + 1/156
We can generate Egyptian Fractions using Greedy Algorithm. For a given number of the form ‘nr/dr’ where dr > nr, first find the greatest possible unit fraction, then recur for the remaining part. For example, consider 6/14, we first find ceiling of 14/6, i.e., 3. So the first unit fraction becomes 1/3, then recur for (6/14 – 1/3) i.e., 4/42. 
 */


import java.io.*;

class Main1{
    static BufferedReader br;
    static BufferedWriter bw;
    public static void findEgyptianFraction(double nr, double dr) throws IOException{
        int ans = 0;
        if(nr == 0 || dr == 0) return;

        // For fraction in last recursion call there will be a situation, that dr will be divisible by nr, bcz, that time nr is 1.
        if(dr % nr == 0) {
            ans = (int)(dr / nr);
            bw.write("1/"+ ans);
            return;
        }

        // If the nr is divisible by dr, then obviously the (nr/dr) is not a fraction 
        if(nr % dr == 0){
            ans = (int)(nr / dr);
            bw.write(ans);
            return;
        }

        // If the number is like 14/6 => 2 + (2/6) => 2 + (1/3) -> here the 2 must be written, and we need to recur the function with dr as same and nr as (nr % dr) (ex: in above example ->           2 + (2 / 6) => floor(14 / 6) + ((14 % 6) / 6) -> here in (2 / 6), 2 is coming from (14 % 6), and this 2 we need to pass as nr, and the 6 as dr). Which is implemented below,
        if(nr > dr){
            ans = (int)(nr / dr);
            bw.write(ans+" + ");
            findEgyptianFraction(nr % dr, dr);
            return;
        }

        // Below implementation is for the normal fractional inputs like (6 / 14)
        double n = Math.ceil(dr / nr);
        bw.write(1+"/"+(int)n+" + ");
        findEgyptianFraction(n * nr - dr, n * dr);
    }


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

        String[] arr = br.readLine().trim().split(" ");

        double nr = Double.parseDouble(arr[0]);
        double dr = Double.parseDouble(arr[1]);

        findEgyptianFraction(nr, dr);      

        br.close();
        bw.close();
    }
}