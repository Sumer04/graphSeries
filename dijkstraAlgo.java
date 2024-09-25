import java.util.Arrays;

public class dijkstraAlgo {

     public static void main(String[] args) {
        int matrix[][] = 
        new int[][] { { 0, 50, 100, 0}, 
        { 50, 0, 30, 200 }, 
        { 100, 30, 0, 20 }, 
        { 0, 200, 20, 0 },};  
        int source =0;
        int distance[]  = Dijkstra(matrix, source);
        for(int i=0; i<distance.length; i++)
        {
            System.out.println(distance[i]);
        }
     } 
     public static int[] Dijkstra(int matrix[][], int source)
     {
        int v = matrix.length;

        int distance[] = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean finalized[] = new boolean[v];
        distance[source] =0;
        for(int count=0; count<v-1; count++)
        {
            int u =-1;
           for(int i =0; i<v; i++)
           {
            if(!finalized[i] && (u==-1|| distance[i]<distance[u]))
            {
                u=i;
            }
           }
           finalized[u]=true;
           for(int max=0; max<v; max++)
           {
            if(!finalized[max] && matrix[u][max]!=0)
            {
            
           
                distance[max] = Math.min(distance[max], distance[u] + matrix[u][max]);
            }
           }
        }
        return distance;
     }
}