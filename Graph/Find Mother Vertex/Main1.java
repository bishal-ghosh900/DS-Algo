import java.util.*;

// For mother vertex do DFS one time, and keep the track of last vertex before exiting the DFS fucntion. If the graph contains any mother vertex then, the previously tracked last vertex will definately be the mother vertex.
// Time complexity -> O(V+E)


public class Main1 {

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
    }

    private static void DFS(int j, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        if(visited[j]) return;
        visited[j] = true;

        for(int i : graph.get(j)){
            if(!visited[i]){
                DFS(i, graph, visited);
            }
        }
        
    }
    
    
    private static int findMotherVertex(ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        int v = -1;
        
        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]) {
                DFS(i, graph, visited);
                v = i;
            }
        }

        Arrays.fill(visited, false);
        DFS(v, graph, visited);
        for(boolean is : visited){
            if(!is) return -1;
        }
        return v;
    }
    

    


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        
        int N = 7;
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 4, 1);
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 4);
        addEdge(graph, 6, 0);
        
        boolean[] visited = new boolean[N];
        int motherVertex = findMotherVertex(graph, visited);
        System.out.println(motherVertex != -1 ? motherVertex : "There is no mother vertex.");
    }

    
    


}