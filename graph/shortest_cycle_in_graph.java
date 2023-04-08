package graph;

import java.util.ArrayList;
import java.util.*;
public class shortest_cycle_in_graph {

    static int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(adj);
        int[] vis=new int[n];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1) continue;
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty())
            {
                int curr = q.remove();
                vis[curr]=1;
                for (int child : adj.get(curr))
                {
                    if (dist[child] == Integer.MAX_VALUE)
                    {
 
                        dist[child] = 1 + dist[curr];

                        parent[child] = curr;
                        q.add(child);
                    } else if (parent[curr] != child && parent[child] != curr)
                        ans = Math.min(ans, dist[curr] + dist[child] + 1);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }

    public static void main(String[] args)
    {
        int[][] e={{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
        System.out.println(findShortestCycle(7, e));
    }
    
}
