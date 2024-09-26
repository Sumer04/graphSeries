import java.util.*;

public class detectDirectedGraphUsingTopologicSorting {

     public static void main(String[] args) {
           int v =6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for(int i=0; i<v; i++)
        {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1); 
        addEdge(adj,2,1); 
        addEdge(adj,2,3); 
        addEdge(adj,3,4); 
        addEdge(adj,4,5);
        addEdge(adj,5,3);
      boolean ans=  DetectedCycleInDirectedGraph(adj,v);
      System.out.println(ans);
     }
     static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
     { 
         adj.get(u).add(v); 
     }
     public static  boolean DetectedCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adj ,int v)
     {
        Queue<Integer> q = new LinkedList<>();
          int in_degree[] =  new int[v];
          for(int u=0; u<v; u++)
          {
            for(int auto:adj.get(u))
            {
                in_degree[auto]++;
            }
          }
          for(int i =0; i<v; i++)
          {
            if(in_degree[i]==0)
            {
                q.add(i);
            }
          }
          while(!q.isEmpty())
          {
            int u = q.poll();
            for(int auto:adj.get(u))
            {
                if(in_degree[auto]==0)
                {
                    return true;
                }
                --in_degree[auto];
                if(in_degree[auto]==0)
                {
                    q.add(auto);
                }
            }
          }
          return false;
     }
}