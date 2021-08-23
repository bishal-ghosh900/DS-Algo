// Two characters will be provided by the user as c1 and c2. 
// if c2 is some character which is at some distance from c1.
// find the next character after c2 after that same distace.

// If input c1 = 'c', c2 = 'g', then output c3 = 'k'
// As after c there is 3 characters('d','e','f') and then 'g'.
// So after 'g', geting upto 3 characters('h','i','j') we have 'k'.


// If the distance is greater than 'z' , then after 'z' find it from the first.
// Like if input c1 = 'r', c2 = 'l', then output c3 = 'f'
// Here after 'r' there is ('s' -> 'z' => 8 characters 
// and then do it from 'a' -> 'k' => 11 charcters) 8 + 11 = 19 characters for 'r' -> 'l'.
// So, after 'l' go to upto 19 characters ('m' -> 'z' => 14 characters
// and then more 5 characterss from first(i.e 'a')), which is ('a' -> 'e' => 5 characters) 'f'.


import java.util.*;
public class Main1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char a = sc.nextLine().charAt(0);
        char b = sc.nextLine().charAt(0);

        sc.close();

        int aN = (int)a;
        int bN = (int)b;
        
        int cN = ((aN < bN) ? (Math.abs(aN - bN) + bN) : (Math.abs(aN - bN) + 96));

        if(cN > 122){
            cN = cN - 122 + 96;
        }

        //System.out.println("a: "+(int)a+", b: "+(int)b+" & cN: "+cN);

        System.out.println((char)cN);
    }
}