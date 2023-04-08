package graph;
import java.util.*;
public class number_of_provinces {

    static void dfs(ArrayList<ArrayList<Integer>> adj,int start,int V,int[] vis)
    {
        vis[start]=1;
        for(int i=0;i<V;i++)
        {
            if(i!=start && adj.get(start).get(i)==1 && vis[i]==0) dfs(adj, i, V, vis);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        System.out.println(adj);
        int[] vis=new int[V];
        int c=0;
        for(int i=0;i<V;i++)
        {
           if(vis[i]==0)
           {
            c++;
            dfs(adj, i, V, vis);
           }

            for(int k:vis) System.out.print(k+",");
            System.out.println();
        }
        return c;
     
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);list1.add(0);//list1.add(1);
        adj.add(new ArrayList<>(list1));
        list1.clear();
        list1.add(0);list1.add(1);//list1.add(0);
        adj.add(new ArrayList<>(list1));
        // list1.clear();
        // list1.add(1);list1.add(0);list1.add(1);

        // adj.add(list1);

        System.out.println(numProvinces(adj, 2));
    }
    
}
