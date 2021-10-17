import java.io.*;


// input() to take one line as an input from the input file
// print() to print one line but will not provide new line at the end
// println() to print one line and will provide new line at the end

class Main1{

    public static void solution() throws IOException{
        
    }
       
    public static void main(String[] args) throws IOException{

        // input() to take one line as an input from the input file
        // print() to print one line but will not provide new line at the end
        // println() to print one line and will provide new line at the end
        
        solution(); // solution() is for you to work
        free(); // free() is for flushing and closing the streams        
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static {
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static String input() throws IOException{
        return br.readLine();
    }
    public static <T> void print(T line) throws IOException{
        bw.write(String.valueOf(line));
    }
    public static <T> void println(T line) throws IOException{
        bw.write(String.valueOf(line));
        bw.newLine();
    }
    public static void free() throws IOException{
        br.close();
        bw.close();
    }
}