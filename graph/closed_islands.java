package graph;
import java.util.*;
public class closed_islands {

    void dfs(int[][] g,int x,int y)
    {
        if(x<0 || y<0 || x>=g.length || y>=g[x].length || g[x][y]==1) return;
        g[x][y]=1;
        dfs(g, x+1, y);
        dfs(g, x-1, y);
        dfs(g, x, y+1);
        dfs(g, x, y-1);
    }
    public int closedIsland(int[][] grid) {
      
        //corner rows
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++)
        {
           for(int j=0;j<grid[i].length;j++)
           {
               if(i==0 || j==0 || i==row-1 || j==grid[i].length-1)
                   dfs(grid,i,j);
           }
        }

        int ans=0;
        for(int i=1;i<row-1;i++)
        {
            for(int j=1;j<col-1;j++)
            {
                if(grid[i][j]==0) 
                {
                    ans++;
                    dfs(grid, i, j);
                }
            }

        }
        return ans;
        
    }
    
}
