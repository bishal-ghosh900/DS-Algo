// Huffman Coding ->

import java.io.*;
import java.util.*;

class Node{
    int f;
    char c;
    Node left, right;
    Node(char c, int f){
        this.f = f;
        this.c = c;
        this.left = null;
        this.right = null;
    }
}

class Main1{

    public static void getCodes(char[] chars, int[] freq) throws IOException{
        PriorityQueue<Node> q = new PriorityQueue<>((a , b) -> a.f - b.f);

        int len = chars.length;
        for(int i = 0; i < len; i++){
            q.add(new Node(chars[i], freq[i]));
        }

        while(q.size() > 1){
            Node a = q.poll();
            Node b = q.poll();
            Node x = new Node('\0', a.f + b.f);
            x.left = a;
            x.right = b;
            q.add(x);
        }

        String code = "";
        doTraverse(q.poll(), code);
    }

    public static void doTraverse(Node root, String code) throws IOException{

        if(root == null) return;
        doTraverse(root.left, code + "0");
        if(root.c != '\0'){
            println(root.c+" -> "+ code);
        }
        doTraverse(root.right, code + "1");
    }

    public static void solution() throws IOException{
        char[] chars = input().replace(" ", "").toCharArray();
        int[] freq = Arrays.stream(input().split(" ")).mapToInt(Integer::parseInt).toArray();

        getCodes(chars, freq);
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