import java.util.*;

public class topologicSortingUsingDfs {
    public static void main(String[] args) {
        int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
        for (int i = 0; i < V; i++) 
        adj.add(new ArrayList<Integer>()); 

        addEdge(adj,0, 1); 
        addEdge(adj,1, 3); 
        addEdge(adj,2, 3); 
        addEdge(adj,3, 4); 
        addEdge(adj,2, 4); 
    
        topologicalSortingKanfBasedDfs(adj, V);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u , int v)
    {
        adj.get(u).add(v);
    }
    public static void topologicalSortingKanfBasedDfs(ArrayList<ArrayList<Integer>> adj, int v)
    {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[v];

        for(int i=0;i<v; i++)
        {
            if(!visited[i])
            {
                Dfs(adj,s,i,visited);
            }
        }
              
        while (s.empty() == false) 
            System.out.print(s.pop() + " "); 
       
    }

    
    public static void Dfs(ArrayList<ArrayList<Integer>> adj ,  Stack<Integer> s,int u,boolean visited[])
    {
      visited[u] = true;
        for(int auto:adj.get(u))
        {
            if(!visited[auto])
            {
                Dfs(adj, s, auto, visited);
            }
        }
        s.push(u);
    }
}
