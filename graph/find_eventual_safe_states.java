class Solution {
     static boolean check(int[][] g,int start,int[] vis,int[] pathvis)
    {
        vis[start]=1;
        pathvis[start]=1;

        for(int i=0;i<g[start].length;i++)
        {
            int node=g[start][i];
            if(pathvis[node]==1) return true;
            if(vis[node]==0 && check(g, node, vis, pathvis)) return true;
        }
        pathvis[start]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] g) {
        
     int[] vis=new int[g.length],pathvis=new int[g.length];
        for(int i=0;i<g.length;i++)
        {
            if(vis[i]==0) check(g, i, vis, pathvis);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<g.length;i++)
        {
            if(pathvis[i]==0) ans.add(i); 
        }
        return ans;
       
    }
}
