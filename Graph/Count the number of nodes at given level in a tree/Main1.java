/**
 * Main1
 */

import java.util.*;
class Graph{
    private ArrayList<ArrayList<Integer>> g;
    Graph(int size){
        g = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            g.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        g.get(u).add(v);
        g.get(v).add(u);
    }

    public int BFS(int i, int level) {

        Queue<Integer> q = new ArrayDeque<>();
        int depth[] = new int[g.size()];
        boolean visited[] = new boolean[g.size()];
        q.offer(i);

        depth[i] = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            visited[temp] = true;
            
            for(int v : g.get(temp)){
                if(!visited[v]){
                    depth[v] = depth[temp] + 1; // every vertex having depth = depth[parent] + 1; for depth[0] = 0.
                    q.offer(v);
                }
            }
        }

        int countNodes = (int)Arrays.stream(depth).filter(k -> k == level).count();       

        return countNodes;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        int level = 2;
        System.out.print(g.BFS(0, level));
    }
}