package graph;
import java.util.*;
class newPair
{
    int node;int dis;
    newPair(int a,int b)
    {
        node=a;dis=b;
    }
}
public class dijkstra_algorithm {

    //using priority queue and min heap implementation
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        PriorityQueue<newPair> pq=new PriorityQueue<>((x,y)->x.dis-y.dis);
        int[] dis=new int[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        pq.add(new newPair(s,0));
        while(!pq.isEmpty())
        {
            newPair curr=pq.remove();
            int len=curr.dis;
            int node=curr.node;
            for(List<Integer> l:adj.get(node))
            {
                int x=len+l.get(1);
                if(dis[l.get(0)]>x)
                {
                dis[l.get(0)]=x;
                pq.add(new newPair(l.get(0),x));
                }
            }

        }
        return dis;

    }
    //using set implementation is possible only in java

    //printing the path calculated
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        PriorityQueue<newPair> pq=new PriorityQueue<>((x,y)->x.dis-y.dis);

        List<List<newPair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new newPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new newPair(edges[i][0], edges[i][2]));
        }

        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        dis[1]=0;
        pq.add(new newPair(1,0));

        while(!pq.isEmpty())
        {
            newPair temp=pq.remove();
            int currdis=temp.dis;
            int curr=temp.node;
            if(curr==n) break;
            for(newPair p: adj.get(curr))
            {
                if(p.dis+currdis<=dis[p.node])
                {
                    dis[p.node]=p.dis+currdis;
                    parent[p.node]=curr;
                    pq.add(new newPair(p.node, dis[p.node]));
                }
            }
        }
        int curr=n;
        List<Integer> list=new ArrayList<>();
        list.add(curr);
        while(curr!=1)
        {
            list.add(0,parent[curr]);
            curr=parent[curr];
        }
        return list;
    }


    public static void main(String[] args)
    {
        int[][] edges= { { 1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        System.out.println(shortestPath(5, 6, edges));

    }
    
}
