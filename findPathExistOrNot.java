public class findPathExistOrNot {

    public static void main(String[] args) {
       int  grid[][] = {{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
      boolean ans= is_Possible(grid);
      System.out.println(ans);
    }
    public static boolean is_Possible(int[][] grid)
    {
        for(int i=0;i<grid.length; i++){
            for(int j =0; j<grid.length; j++){
                if(grid[i][j]==1)
                {
                    return findPathExistOrNot(grid,i,j);
                }
            }
        }
        return false;
    }
    public static boolean findPathExistOrNot(int grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j]==0)
        {
            return false;
        }
        if(grid[i][j]==2)
        {
            return true;
        }
        grid[i][j]=0;
        return findPathExistOrNot(grid,i+1,j) || findPathExistOrNot(grid,i-1,j) || findPathExistOrNot(grid,i,j+1) || findPathExistOrNot(grid,i,j-1);
    }
}