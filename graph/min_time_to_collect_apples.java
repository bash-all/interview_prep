package graph;

import java.util.*;


public class min_time_to_collect_apples {

    //creating adjacency list
    static HashMap<Integer,List<Integer>> create(int[][] edges)
    {
        HashMap<Integer,List<Integer>> h=new HashMap<>();
        for (int[] i : edges) {
            int a=i[0],b=i[1];
            List<Integer> list=h.getOrDefault(a, new ArrayList<>());
            list.add(b);
            h.put(a,list);

            List<Integer> l=h.getOrDefault(b, new ArrayList<>());
            l.add(a);
            h.put(b,l);
        }
        System.out.println(h);
        return h;
    }

    public static void main(String[] args)
    {
        int[][] a={{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple=new ArrayList<>();


        HashMap<Integer,List<Integer>> adj=create(a);
        dfs(adj, 0, 0, hasApple, new HashSet<>());


    }
    static int dfs(HashMap<Integer,List<Integer>> h,int cost,int node,List<Boolean> hasApple,Set<Integer> visit)
    {
        if(visit.contains(node)) return 0;
        visit.add(node);

        int childcost=0;

        for(int n:h.getOrDefault(node,null))
        {
            childcost+=dfs(h, 2, n, hasApple, visit);
        }

        if(childcost==0 && hasApple.get(node)==false) return 0;
        return cost+childcost;
    }
    
}
