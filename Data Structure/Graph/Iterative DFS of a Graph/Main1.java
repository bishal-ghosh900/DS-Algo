import java.util.*;


class Graph {
    private List<ArrayList<Integer>> graph;

    Graph(int size) {
        graph = new ArrayList<>();
        for(int i = 0; i < size; i++){
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
    }

    void iterativeDFS(int v){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        s.push(v);
        while(!s.isEmpty()){
            int vertex = s.pop();
            visited[vertex] = true;

            System.out.print(vertex+" ");
            
            for(int i : graph.get(vertex)){
                if(!visited[i])
                    s.push(i);
            }
        }
    }

    void printGraph() {
        for(int i = 0; i < graph.size(); i++){
            System.out.println(i+" -> "+ graph.get(i));
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        graph.iterativeDFS(0);


    }
}