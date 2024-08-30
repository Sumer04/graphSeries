import java.util.*;
public class possiblepathBetweenTwoVertex {
     public static void main(String[] args) {
        int v = 5;
        int edge = 7;
        int source = 0;
        int destination = 4;


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

      
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);
        adj.get(3).add(2);
        int ans  =  countPaths( v,  adj,  source,
        destination);
        System.out.println(ans);
     }
 public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
      int destination)
  {
        int ans[] = new int[1];
         dfs(source,destination,adj,ans);
         return ans[0];
}
public static void dfs(int source,int destination, ArrayList<ArrayList<Integer>> adj ,int ans[])
{
    if(source==destination)
    {
     ans[0]++;
     }
    for(int adjacent:adj.get(source))
    {
    dfs(adjacent, destination, adj, ans);
    }

}


}