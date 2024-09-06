 import java.util.*;

public class sumOFminimumSpaningTree {
    public static void main(String[] args) {
        int V=3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges =  {{0, 1, 5}, {1,2,3}, {0,2,1}};
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
       
        for (int i = 0; i < 3; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
       int ans = MinimumSpaningTree(V, adj,edges);
       System.out.println(ans);
    }
    public static int MinimumSpaningTree(int V,  ArrayList<ArrayList<ArrayList<Integer>>> adj,int edges[][])
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int vis[] =new int[V];
        pq.add(new Pair(0, 0));
        int sum =0;
        while(!pq.isEmpty())
        {
            int weight =  pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            if(vis[node]==1)
            {
                continue;
            }
            vis[node]=1;
            sum =sum +weight;
            for(int i =0; i<adj.get(node).size(); i++)
            {
                int edj = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(vis[adjNode]==0)
                {
                    pq.add(new Pair(edj, adjNode));
                }
            }
        }
        return sum;
    }
}
class Pair{
    int node;
    int distance;
    Pair(int distance, int node)
    {
        this.node=node;
        this.distance = distance;
    }
}


