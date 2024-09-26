import java.util.ArrayList;

public class detectedCycleInDirectedGraph {
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

      public static void addEdge(ArrayList<ArrayList<Integer>> adj , int u, int v)
      {
            adj.get(u).add(v);
            
      }
      public static boolean DetectedCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adj,int v)
      {
            boolean visited[] = new boolean[v];
            boolean recursionStack[]= new boolean[v];

            for(int i =0; i<v; i++)
            {
                  if(!visited[i]){
                        if(DfsRecursion(adj,visited,recursionStack,i)){
                              return true;
                        }
                  }
                  
            }
            return false;
      }
      public static boolean DfsRecursion(ArrayList<ArrayList<Integer>> adj,boolean[] visited, boolean[] recursionStack, int s)
      {
               visited[s]=true;
               recursionStack[s]= true;
               for(int auto:adj.get(s))
               {
                  if(!visited[auto] && DfsRecursion(adj, visited, recursionStack, auto))
                  {
                        return true;
                  }else if(recursionStack[auto]==true){
                        return true;
                  }
         
               }
               recursionStack[s] =false;
               return false;
      }
}