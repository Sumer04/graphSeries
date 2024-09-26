import java.util.ArrayList;

public class detectedCycleInundirectedGraph {
    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1); 
        addEdge(adj,1,2); 
        addEdge(adj,2,4); 
        addEdge(adj,4,5); 
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        System.out.println(Dfs(adj, V));
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
  
     
    public static boolean CycleFound( ArrayList<ArrayList<Integer>> adj,int i ,boolean visited[],int parent)
    {
        visited[i]=true;
        for(int auto:adj.get(i)){
            if(!visited[auto])
            {
               if(CycleFound(adj, auto, visited, i)){
                return true;
               };
            }
           else if(auto!=parent)
           {
            return true;
           }
        }
        return false;
    }
    public static boolean Dfs(ArrayList<ArrayList<Integer>> adj , int V)
    {
        boolean visited[] =  new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            {
                if(CycleFound(adj,  i,visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
