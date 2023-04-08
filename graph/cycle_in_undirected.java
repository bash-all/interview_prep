package graph;
import java.util.*;
class Pair
{
    int x;int y;
    Pair(int a,int b)
    {
        x=a;y=b;
    }
}
public class cycle_in_undirected {

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashMap<Integer,List<Integer>> h=new HashMap<>();
        for(int i=0;i<adj.size();i++)
        {
            List<Integer> l=adj.get(i);
            h.put(i+1,l);
        }

        Deque<Pair> q=new LinkedList<>();
        q.add(new Pair(1,-1));
        boolean[] visit=new boolean[V+1];
        visit[1]=true;
        while(!q.isEmpty())
        {
            Pair p=q.removeFirst();
            int parent=p.y;
            
            List<Integer> l=h.get(p.x);
            for(int i=0;i<l.size();i++)
            {
                if(l.get(i)!=parent)
                q.add(new Pair(l.get(i),p.x));
                if(visit[l.get(i)]) return true;
                else visit[l.get(i)]=true;
            }
            System.out.println(q);
        }

        return false;
        
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(2);temp.add(3);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(5);temp.add(1);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(1);temp.add(6); temp.add(4);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(3);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(2);temp.add(7);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(3);temp.add(7);
        l.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(5);temp.add(6);
        l.add(new ArrayList<>(temp));
        temp.clear();


        System.out.println(isCycle(7, l));
    }
    
}
