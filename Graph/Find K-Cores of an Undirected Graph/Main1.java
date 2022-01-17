import java.util.*;
class Graph {
    private LinkedHashMap<Integer, ArrayList<Integer>> graph;
    Graph(int size){
        graph = new LinkedHashMap<>(size);
        for(int i = 0; i < size; i++){
            graph.put(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void printKcores(int K){
        LinkedHashMap<Integer, ArrayList<Integer>> kCoreGraph = new LinkedHashMap<>(graph.size());
        for(int is: graph.keySet()){
            kCoreGraph.put(is, new ArrayList<>(graph.get(is)));
        }

        for(int i = 0; i < graph.size(); i++){
            if(kCoreGraph.containsKey(i) && kCoreGraph.get(i).size() < K){
                removeVertex(i, K, kCoreGraph);
            }
        }
        
        
        for(int j : kCoreGraph.keySet()){
            System.out.println(j + " -> "+ kCoreGraph.get(j));
        }
    }
    

    private void removeVertex(int i, int K, LinkedHashMap<Integer, ArrayList<Integer>> kCoreGraph) {
        for(int j = 0; j < kCoreGraph.get(i).size(); j++){
            if(!kCoreGraph.get(kCoreGraph.get(i).get(j)).contains(Integer.valueOf(i)))
                return;
            kCoreGraph.get(kCoreGraph.get(i).get(j)).remove(Integer.valueOf(i));
            
            if(kCoreGraph.get(kCoreGraph.get(i).get(j)).size() < K && kCoreGraph.get(kCoreGraph.get(i).get(j)).size() != 0)
                removeVertex(kCoreGraph.get(i).get(j), K, kCoreGraph);
        }
        kCoreGraph.remove(Integer.valueOf(i));
    }

    public void printGraph(){
        for(int i = 0; i < graph.size(); i++){
            System.out.println(i + " -> "+ graph.get(i));
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);

        int K = 3;
        graph.printKcores(K);
    }
}