public class Main1 {
    public static void main(String[] args) {
        String text = "mnonopoo";

        // aabaa

        int r = 0;
        int ans = 0;
        int pointer = 1;

        for(int i = 0; i < text.length(); i++){
            pointer = 1;
            if(i+1 < text.length() && text.charAt(i) == text.charAt(i + 1)){
                r++;
            }
            else{
                ans += r * (r + 1) / 2 ;
                r = 0;
            }

            while
            (
                i - pointer >= 0 && i + pointer < text.length() &&
                text.charAt(i - 1) == text.charAt(i - pointer) &&
                text.charAt(i - 1) == text.charAt(i + pointer) && 
                text.charAt(i) != text.charAt(i - 1)
            ){
                pointer++;
                ans++;
            }
        }

        ans += text.length();

        System.out.println(ans);

    }
}
