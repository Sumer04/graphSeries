import java.util.*;
public class bfs {
    public static void main(String[] args) {
        int V =  5;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i=0; i<V; i++)
        {
           adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1); 
    	addEdge(adj,0,2); 
    	addEdge(adj,1,2); 
    	addEdge(adj,2,3); 
    	addEdge(adj,1,3);
    	addEdge(adj,3,4);
    	addEdge(adj,2,4);
      //  bfs(adj, V, 0);
   int ans =   BfsDisconnected(adj, V);
   System.out.println(ans);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>>adj , int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    // when there are two group of disconnected Graph
    public static int  BfsDisconnected(ArrayList<ArrayList<Integer>>adj, int V)
    {
        boolean  visited[] =  new boolean[V];
        // check this for no. of island
        int count=0;
        for(int i = 0; i<V; i++)
        {
            if(!visited[i])
            {
               bfs(adj, visited, i);
               count++;
            }
        }
        return count;
    }
    public static void bfs(ArrayList<ArrayList<Integer>>adj,boolean visited[],int s)
    {

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while(!q.isEmpty())
        {
            int u =  q.poll();
            System.out.println(u);
            for(int auto:adj.get(u))
            {
                if(!visited[auto])
                {
                    q.add(auto);
                    visited[auto] =true;
                }
            }
         
        }
    }
}
