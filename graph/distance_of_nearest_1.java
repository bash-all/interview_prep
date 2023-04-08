package graph;

import java.util.*;
class Pairs
{
    int x;int y;int step;
    Pairs(int a,int b,int c)
    {
        x=a;y=b;step=c;
    }
}
public class distance_of_nearest_1 {

    static boolean isValid(int x,int y,int[][] g)
    {
        if(x<0 || y<0 || x>=g.length || y>=g[0].length) return false;
        return true;
    }

    static int[][] nearest(int[][] g)
    {
        int row=g.length,col=g[0].length;
        int[][] ans=new int[row][col];
        boolean[][] visit=new boolean[row][col];
        Queue<Pairs> q=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(g[i][j]==1)
                {
                q.add(new Pairs(i, j, 0));
                visit[i][j]=true;
                }
            }
        }
        int[][] dis={{0,1},{0,-1},{1,0},{-1,0}};
        //turn true there and there to avoid reupdation of steps later 
        while(!q.isEmpty())
        {
            Pairs p=q.remove();
            int x=p.x,y=p.y,step=p.step;
                
            ans[x][y]=step;
            for(int i=0;i<4;i++)
            {
                int row1=x+dis[i][0],col1=y+dis[i][1];
                if(isValid(row1,col1,g) && !visit[row1][col1])
                { q.add(new Pairs(row1,col1,step+1));
                visit[row1][col1]=true;
                }
            }

        }
        return ans;
        
    }

    public static void main(String[] args)
    {
        int[][] g={  {0 ,1 ,1, 0 },
                     {1 ,1 ,0, 0 } ,
                     {0, 0, 1 ,1 }};

        
        int[][] ans=nearest(g);
        for (int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j]+",");
            }
            System.out.println();
        }
            
        }
    }
    

