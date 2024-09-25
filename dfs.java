import java.util.*;
public class dfs {
    public static void main(String[] args) {
        int V =5;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i=0; i<V; i++)
        {
           adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1); 
        addEdge(adj,0,2); 
        addEdge(adj,1,2);
        addEdge(adj,3,4);
       int count= Dfs(adj, V,0);
       System.out.println(count);
    }

    public static int  Dfs(ArrayList<ArrayList<Integer>>adj,int V,int s){
       boolean visited[] = new boolean[V];
    //    DfsRecursive(adj,visited, s);


    // this is for the disconnected graph and find the common common components also
    int count =0;

    for(int i =0; i<V; i++){
        if(!visited[i]){
        DfsRecursive(adj,visited,i);
        count++;
        }
    }
    return count;

    }

    public static void DfsRecursive(ArrayList<ArrayList<Integer>>adj,boolean visited[], int s)
    {
        visited[s] = true;
        System.out.println(s);
       for(int auto:adj.get(s))
       {
        if(!visited[auto])
        {
            DfsRecursive(adj,visited,auto);
        }
       }
    }
    public static void addEdge(ArrayList<ArrayList<Integer>>adj , int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
