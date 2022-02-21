// Input ->
// first 1 is the no. of test cases and the last 1 is the vertex number from where the algorithm will start.
/**
1
6 5
0 3 9
0 5 4
1 4 4
2 5 10
4 5 3
1
 */

// Output -> 
// 11 0 17 20 4 7 

import java.util.*;
import java.io.*;


class Main1
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) 
    // Time complexity -> O(V * V)
    {
        boolean[] selected = new boolean[V]; // It's mainly visited[] array.
        int[] dist = new int[V]; // It's containig all of the minimum path value from the start vertex S.
        
        Arrays.fill(dist, Integer.MAX_VALUE); // Fill all the value of dist with Infinity

        dist[S] = 0; // Make the dist[start_vertex] = 0. As we are starting from the S, so minimum distance from S to S is 0.
        
        for(int i = 0; i < V - 1; i++){ // Loop till V - 1, cause if we go till V - 2, then we will be able to get dist of all the vertices, no need to go to the last vertex. Following algo will define the rest.
            int u = minDistVertex(selected, dist); // find the vertex which is having dist[vertex] minimun and not selected (i.e. selected[vertex] == false).
            selected[u] = true; // make it selected
            for(ArrayList<Integer> list: adj.get(u)){ // loop for all the vertices to which u is connected.
                int v = list.get(0);
                int w = list.get(1);
                if(!selected[v] && dist[v] > dist[u] + w){ // Update the dist[vertex] value
                    // of all the vertices which is connected to u and not selected and 
                    // satisfying the condition dist[v] > dist[u] + w. This method is called
                    // Relaxation.
                    dist[v] = dist[u] + w ;
                }
            }
        }
        
        return dist; // return the dist array
    }
    
    int minDistVertex(boolean[] selected, int[] dist){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < selected.length; i++){
            if(!selected[i] && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

