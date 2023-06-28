class Solution {
    class pair
    {
        int node;double dis;
        pair(int n,double d)
        {
            node=n;dis=d;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {
        
        Map<Integer,List<pair>> adj=new HashMap<>();
        
        
        
        for(int i=0;i<edges.length;i++)
        {
            adj.computeIfAbsent(edges[i][0],v->new ArrayList<>()).add(
                                                        new pair(edges[i][1],succ[i]));
            adj.computeIfAbsent(edges[i][1],v->new ArrayList<>()).add(
                                                        new pair(edges[i][0],succ[i]));
        }
        
        Deque<pair> q=new LinkedList<>();
        q.add(new pair(start,1.0));
        double[] dis=new double[n];
        dis[start]=1.0;
        while(!q.isEmpty())
        {
            int curr=q.peek().node;
            double currdis=q.remove().dis;
            
            if(curr==end || !adj.containsKey(curr)) continue;
            for(pair p:adj.get(curr))
            {
                if(currdis*p.dis>dis[p.node])
                {
                    dis[p.node]=currdis*p.dis;
                    q.add(new pair(p.node,dis[p.node]));
                }
            }
            
        }
        
        return dis[end];
                                                                                                                                                                 
    }
}