import java.util.*;
public class levelOfNodes {
    public static void main(String[] args) {
        int V = 6;
        int X =4;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
      
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        int ans = nodeLevel(V, adj, X);
        System.out.println(ans);
    }
    static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Integer>q =  new LinkedList<>();
        boolean  visited[] =  new boolean[V];
        for(int i =0; i<V; i++)
        {
            visited[i] = false;
        }
        q.add(0);
        visited[0] =true;
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i =0; i<size; i++){
            int currentNode=   q.poll();
            if(currentNode==X){
                return level;
            }
            for(int adjacent:adj.get(currentNode))
            {
                if(visited[adjacent]==false)
                {
                    q.add(adjacent);
                    visited[adjacent] = true;
                }
            }
            
        }
        level++;
    }
        return -1;
    }

}
