import java.util.ArrayList;

public class makeAadjancyList {
    public static void main(String[] args) {
        int V =4;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i = 0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }
        AddEdge(adj, 0, 1);
        AddEdge(adj, 0, 2);
        AddEdge(adj, 1, 3);
        AddEdge(adj, 2, 0);
        AddEdge(adj, 2, 1);
        AddEdge(adj, 2, 3);
        printGraph(adj);
    }
    public static void AddEdge(ArrayList<ArrayList<Integer>>adj , int u , int v)
    {
     adj.get(u).add(v);
     adj.get(v).add(u);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>>adj)
    {
        for(int i=0; i<adj.size(); i++)
        {
            for(int j=0; j<adj.get(i).size(); j++)
            {
                System.out.print(adj.get(i).get(j) + "");
            }
            System.out.println();
        }
    }
}
