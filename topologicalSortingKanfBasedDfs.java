import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSortingKanfBasedDfs {
    public static void main(String[] args) {
        int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
        for (int i = 0; i < V; i++) 
        adj.add(new ArrayList<Integer>()); 

        addEdge(adj,0, 2); 
        addEdge(adj,0, 3); 
        addEdge(adj,1, 3); 
        addEdge(adj,1, 4); 
        addEdge(adj,2, 3);
        topologicalSortingKanfBasedDfs(adj, V, V);
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
	}
    public static void topologicalSortingKanfBasedDfs(ArrayList<ArrayList<Integer>>adj,int s,int v)
    {


        Queue<Integer> q = new LinkedList<>();
        int [] in_degree=  new int[v];
        for(int u=0; u<v; u++)
        {
            for(int x:adj.get(u))
            {
                in_degree[x]++;
            }
        }
        for(int i=0; i<v; i++)
        {
            if(in_degree[i]==0)
            {
                q.add(i);
            }
        }
    
     while(!q.isEmpty())
        {
        int u = q.poll();
        System.out.println(u);
        for(int auto :adj.get(u))
        {
           --in_degree[auto];
           if(in_degree[auto]==0)
           {
            q.add(auto);
           }
        }
        }
    }
}
