public class XtotalShape {
    public static void main(String[] args) {
        char grid[][] = {
            {'O', 'X', 'O','X','X'},
            {'O', 'O', 'X','X','X'},
            {'O', 'X', 'X','O','O'},
            {'X', 'X', 'O','O','O'},
            {'O', 'X', 'X','X','O'},
            {'X', 'X', 'O','O','X'},
        };
        int ans  =XtotalShape(grid);
        System.out.println(ans);

    }
    public static void dfs(char grid[][],int i, int j)
    {
        if(i<0 || j<0 ||i>=grid.length || j>= grid[0].length || grid[i][j]=='O')
        {return;}
       grid[i][j] ='O';
       dfs(grid, i+1, j);
       dfs(grid, i-1, j);
       dfs(grid, i, j+1);
       dfs(grid, i, j-1);
    }
    public static int XtotalShape(char grid[][])
    {
        
        int ans =0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]=='X')
                {
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
