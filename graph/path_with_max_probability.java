class Solution {
    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {
        
        //bellman ford variant
        double[] dis=new double[n];
        dis[start]=1.0;
        for(int i=0;i<n;i++)
        {
            boolean flag=false;
            for(int j=0;j<edges.length;j++)
            {
                int u=edges[j][0],v=edges[j][1];
                if(dis[v]<dis[u]*succ[j])
                {
                    dis[v]=dis[u]*succ[j];
                    flag=true;
                }
                if(dis[u]<dis[v]*succ[j])
                {
                    dis[u]=dis[v]*succ[j];
                    flag=true;
                }
            }
            
            if(!flag) break;
        }
        return dis[end];
    }
}


