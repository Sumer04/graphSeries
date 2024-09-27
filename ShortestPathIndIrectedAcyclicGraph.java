import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

 class ShortestPathInDirectedAcyclicGraph {

    public static void main(String[] args) {
        int v = 6;
        int source = 0;  
        
      
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

       
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 5, 3, 1);

     
        shortestPathInDAG(adj, source, v);
    }

 
    public static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
    }

    
    public static void topologicalSortUsingDFS(ArrayList<ArrayList<Edge>> adj, boolean[] visited, int u, Stack<Integer> stack) {
        visited[u] = true;
        
        for (Edge edge : adj.get(u)) {
            if (!visited[edge.v]) {
                topologicalSortUsingDFS(adj, visited, edge.v, stack);
            }
        }
        

        stack.push(u);
    }

    
    public static void shortestPathInDAG(ArrayList<ArrayList<Edge>> adj, int source, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
     
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUsingDFS(adj, visited, i, stack);
            }
        }

      
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

     
        while (!stack.isEmpty()) {
            int u = stack.pop();

       
            if (distance[u] != Integer.MAX_VALUE) {
                for (Edge edge : adj.get(u)) {
                    if (distance[u] + edge.weight < distance[edge.v]) {
                        distance[edge.v] = distance[u] + edge.weight;
                    }
                }
            }
        }

      
        for (int i = 0; i < v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Distance from source " + source + " to vertex " + i + " is INF");
            } else {
                System.out.println("Distance from source " + source + " to vertex " + i + " is " + distance[i]);
            }
        }
    }
}

class Edge {
    int v;
    int weight;

    public Edge(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}
