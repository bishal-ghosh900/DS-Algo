import java.util.*;


public class Main1 {
    static HashMap<LengthCombo, Integer> DP = new HashMap<>();
    public static void main(String[] args) {
        String str1 = "food";
        String str2 = "money";
        int res = getMinEdits(str1, str1.length(), str2, str2.length());
        System.out.println(res);
    }

    private static int getMinEdits(String str1, int length1, String str2, int length2) {
        
        if(length1 == 0) return length2;
        
        if(length2 == 0) return length1;
        
        if(str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) 
            return getMinEdits(str1, length1 - 1, str2, length2 - 1);
            
        LengthCombo lc = new LengthCombo(length1, length2);

        if(DP.getOrDefault(lc, -1) != -1){
            return DP.get(lc);
        }
        DP.put(lc, 1 + Arrays.stream(new int[]{getMinEdits(str1, length1, str2, length2 - 1), 
            getMinEdits(str1, length1 - 1, str2, length2), 
            getMinEdits(str1, length1 - 1, str2, length2 - 1)}).min().getAsInt());

        return DP.get(lc);
    }
}


class LengthCombo {
    private int length1;
    private int length2;

    LengthCombo(int l1, int l2){
        this.length1 = l1;
        this.length2 = l2;
    }

    public boolean equals(Object obj){
        LengthCombo lc = (LengthCombo) obj;
        return lc.length1 == length1 && lc.length2 == length2 ? true : false;
    }

    public int hashCode() {
        return Objects.hash(length1, length2);
    }
}