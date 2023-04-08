package graph;
import java.util.*;
class Pair2
{
    int node;int dis;
    Pair2(int n,int d)
    {
        node=n;dis=d;
    }
}
public class shortest_path_in_undirected {

    static int[] shortestPath(int[][] ed,int n,int m ,int src) {
        int[] dist=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            List<Integer> temp=new ArrayList<>();
            adj.add(temp);
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(ed[i][0]).add(ed[i][1]);
            adj.get(ed[i][1]).add(ed[i][0]);
        }
        System.out.println(adj);
        int[] vis=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair2> q=new LinkedList<>();
        q.add(new Pair2(src,0));
        dist[src]=0;
        while(!q.isEmpty())
        {
            Pair2 p=q.remove();
            int curr=p.node;
            vis[curr]=1;
            int currdis=p.dis;
            for(int i:adj.get(curr))
            {
                if(vis[i]==1) continue;
                dist[i]=Math.min(dist[i],currdis+1);
                q.add(new Pair2(i, currdis+1));
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        return dist;
    }


    public static void main(String[] args)
    {
        int[][] ed={  {0,1},{0,3},{3,4},{4 ,5}
            ,{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}  };

        int[] ans=shortestPath(ed, 9, 10, 0);
        for(int i:ans)
        {
            System.out.print(i+" , ");
        }
    }
    
}
