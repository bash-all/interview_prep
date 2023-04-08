package graph;
import java.util.*;
class Pair1{
    int first;int val;
    Pair1(int n,int v)
    {
        this.first=n;
        this.val=v;
    }
}
public class shortest_path_in_DAG {

    static void dfs(int[] vis,int start,Stack<Integer> topo,List<List<Pair1>> adj)
    {
        vis[start]=1;
         for(int i=0;i<adj.get(start).size();i++)
         {
            int p=adj.get(start).get(i).first;
            if(vis[p]==0) dfs(vis, p, topo, adj);
         }
        topo.add(start);
    }
	static int[] shortestPath(int n,int m, int[][] ed) {
		List<List<Pair1>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
		{
		    List<Pair1> l=new ArrayList<>();
		    adj.add(l);
		}
		for(int i=0;i<m;i++)
		{
		    adj.get(ed[i][0]).add(new Pair1(ed[i][1],ed[i][2]));
		}
        Stack<Integer> topo=new Stack<>();
		int[] dist=new int[n],vis=new int[n];
		for(int i=0;i<n;i++)
		{
		    if(vis[i]==0) dfs(vis,i,topo,adj);
		}
        System.out.println(topo);

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        while(!topo.isEmpty())
        {
            int curr=topo.pop();
            int currdis=dist[curr];

            for(Pair1 p:adj.get(curr))
            {
                dist[p.first]=Math.min(dist[p.first],currdis+p.val);
            }
        }

        return dist;

	}

    public static void main(String[] args)
    {
        int[][] ed={{0,1,2},{0,4,1},{4,5,4}
            ,{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        int[] ans=shortestPath(6, 7, ed);
        for(int i:ans) System.out.print(i+" , ");
    }
    
}
