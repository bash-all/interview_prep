package graph;

import java.util.*;
class Pair
{
    int x;int y;
    Pair(int a,int b)
    {
        x=a;y=b;
    }
}
public class rotten_oranges {

    static boolean isValid(int[][] g,int x,int y)
    {
        if(x<0 || y<0 || x>=g.length || y>=g[0].length || g[x][y]==0)
        return false;
        g[x][y]=2;
        return true;
    }
    static  int orangesRotting(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        Deque<Pair> q=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                q.add(new Pair(i, j));
            }
        }
        int c=0;
        while(!q.isEmpty())
        {
            c++;
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                Pair p=q.removeFirst();
                if(isValid(grid, p.x+1, p.y)) q.add(new Pair(p.x+1, p.y));
                if(isValid(grid, p.x-1, p.y)) q.add(new Pair(p.x-1, p.y));
                if(isValid(grid, p.x, p.y-1)) q.add(new Pair(p.x,p.y-1));
                if(isValid(grid, p.x, p.y+1)) q.add(new Pair(p.x, p.y+1));
            }
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==1) return -1;
            }
        }
        return c;
        
    }
    
}
