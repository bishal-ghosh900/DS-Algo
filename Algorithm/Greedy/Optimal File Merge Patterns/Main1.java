/**
Optimal File Merge Patterns ->
Difficulty Level : Medium

Given n number of sorted files, the task is to find the minimum computations done to reach the Optimal Merge Pattern. 
When two or more sorted files are to be merged altogether to form a single file, the minimum computations are done to reach this file are known as Optimal Merge Pattern.

If more than 2 files need to be merged then it can be done in pairs. For example, if need to merge 4 files A, B, C, D. First Merge A with B to get X1, merge X1 with C to get X2, merge X2 with D to get X3 as the output file.

If we have two files of sizes m and n, the total computation time will be m+n. Here, we use the greedy strategy by merging the two smallest size files among all the files present.

Approach: 

Node represents a file with a given size also given nodes are greater than 2 
1. Add all the nodes in a priority queue (Min Heap).{node.weight = file size}
2. Initialize count = 0 // variable to store file computations.
3. Repeat while (size of priority Queue is greater than 1) 
    1. create a new node
    2. new node = pq.poll().weight+pq.poll().weight;//pq denotes priority queue, remove 1st smallest and 2nd smallest element and add their weights to get a new node
    3. count += node.weight
    4. add this new node to priority queue; 
 
count is the final answer
 */


import java.io.*;
import java.util.*;

class Main1{

    public static int findOptimalMergePatterns(int n, int[] arr) throws IOException{

        Queue<Integer> q = new PriorityQueue<>();

        for(int i : arr){
            q.add(i);
        }

        int count = 0;

        int nd = 0;
        int fi = 0; // first value
        int se = 0; // second value

        while(!q.isEmpty()){
            fi = q.poll();
            se = q.poll();
            nd = fi + se;
            count += nd;
            if(q.isEmpty()) break;
            q.add(nd);
        }
        
        return count;
    }

    public static void solution() throws IOException{

        int n = Integer.parseInt(input());
        int arr[] = Arrays.stream(input().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = findOptimalMergePatterns(n, arr);
        println(result);
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