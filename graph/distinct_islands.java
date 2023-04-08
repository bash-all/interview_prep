package graph;
import java.util.*;
public class distinct_islands {

    // no of islands
    void dfs(char[][] g,int i,int j)
    {
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]=='0') return ;
         g[i][j]='0';
        dfs(g,i+1,j);
        dfs(g,i-1,j);
        dfs(g,i,j+1);
        dfs(g,i,j-1);
    }
    public int numIslands(char[][] g) {
        
        
        int c=0,row=g.length,col=g[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(g[i][j]=='1') 
                {
                    dfs(g,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    static void dfs(int[][] g,int[][] vis,int x,int y,int row0,int col0, List<String> temp)
    {
        vis[x][y]=1;
        temp.add((x-row0)+" "+(y-col0));
        int n=g.length ,m=g[0].length;
        int[] row={-1,0,1,0};
        int[] col={0 ,-1,0,1};
        
        for(int i=0;i<4;i++)
        {
            int nrow=x+row[i],ncol=y+col[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && g[nrow][ncol]==1)
            {
                dfs(g,vis,nrow,ncol,row0,col0,temp);
            }
        }
        
    }

    static int countDistinctIslands(int[][] g) {
        
        Set<List<String>> ans=new HashSet<>();
        int n=g.length ,m=g[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(g[i][j]==1 && vis[i][j]==0)
                {
                   List<String> temp=new ArrayList<>();
                   dfs(g,vis,i,j,i,j,temp);
                   ans.add(temp);
                }
            }
            
        }
        System.out.println(ans);
        return ans.size();
    }



    public static void main(String[] args)
    {
        int[][] g={{1, 1, 0, 1, 1},
                   {1, 0, 0, 0, 0},
                   {0, 0, 0, 0, 1},
                   {1, 1, 0, 1, 1}  };
        System.out.println(countDistinctIslands(g));


    }
}
