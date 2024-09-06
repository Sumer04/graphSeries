import java.util.*;


public class stepByKnight {
    public static void main(String[] args) {
        int knighPos[]=  {4,5};
        int targetPos[] = {1,1};
        int n=6;
        System.out.println(stepByKnight(knighPos, targetPos, n));
    }
      public static int stepByKnight(int knighPos[],int targetPos[],int n)
      {
        int x1 =  knighPos[0]-1;
        int x2 =  knighPos[1]-1;
        int targety1 = targetPos[0]-1;
        int targety2=targetPos[1]-1;
      
        if(x1==targety1 && x2== targety2)
        {
            return 0;
        }
        Queue<Pair> q =  new LinkedList<>();
        boolean visited[][] =  new boolean[n][n];
        q.add(new Pair(x1, x2,0));
        int direction[][] = {{2, 1}, {2, -1}, {1, -2}, {1, 2}, {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}};
        while(!q.isEmpty())
        {
             Pair current = q.poll();
              int row = current.first;;
              int col = current.second;
              int third = current.third;
              if(row==targety1 && col== targety2)
              {
                  return third;
              }
              visited[row][col]=true;
            for(int dir[]:direction)
            {
                int nrow = row +dir[0];
                int ncol = col +dir[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !visited[nrow][ncol])
                {
                    q.add(new Pair(nrow,ncol,third+1));
                    visited[nrow][ncol]=true;
                }
            }
          
            

           
        }
    
        return 0;
      }

static class Pair{
    int first;
    int second;
    int third;
    Pair(int first, int second,int third)
    {
        this.first=first;
        this.second =second;
        this.third =third;
    }
}
}