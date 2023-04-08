package graph;
import java.util.*;
public class redundant_connections {


    //multiple dfs traversals
    static boolean dfs(Map<Integer,List<Integer>> map,int[] vis,int i)
    {
        if(vis[i]==1)
        return true;
        vis[i]=1;
        for(int child:map.get(i))
        {
            if(vis[child]==0 && dfs(map, vis, child)) return true;
        }
        return false;
    }

    static int[] find_redundant_connections(int[][] edges)
    {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] vis=new int[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            Arrays.fill(vis,0);
            map.computeIfAbsent(edges[i][0], value->new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], value->new ArrayList<>()).add(edges[i][0]);
            if(dfs(map, vis,edges[i][0])) return edges[i];
        }
        return new int[]{-1,-1};
    }

    //single dfs traversal
    static boolean dfs(Map<Integer,List<Integer>> map,int child,int parent,Set<Integer> cycle,List<Integer> visit)
    {
        if(visit.contains(child)) 
        {
            cycle.add(child);
            return true;
        }

        visit.add(child);

        for(int i:map.get(child))
        {
            if(i!=parent && dfs(map, i, child, cycle, visit)){
                if(cycle.contains(child))
                return false;
                else
                {
                    cycle.add(child);
                    return true;
                }
            }
        }
        return false;
    }


    static int[] redundant2(int[][] e)
    {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<e.length;i++)
        {
            map.computeIfAbsent(e[i][0], value->new ArrayList<>()).add(e[i][1]);
            map.computeIfAbsent(e[i][1], value-> new ArrayList<>()).add(e[i][0]);
        }
        Set<Integer> cycle=new HashSet<>();

        dfs(map, 1, -1, cycle, new ArrayList<>());

        for(int i=e.length-1;i>=0;i--)
        {
            if(cycle.contains(e[i][0]) && cycle.contains(e[i][1])) return e[i];
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args)
    {
        int[][] e={ {1,2}, {2,3},{3,4},{1,4},{4,5}};
        int[] ans=redundant2(e);
        System.out.println(ans[0]+" "+ans[1]);
    }


    
}
