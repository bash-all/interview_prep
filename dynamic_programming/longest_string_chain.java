package dynamicp;
import java.util.*;
class Pair1
{
    String s;int val;
    Pair1(String a,int i)
    {
        s=a;val=i;
    }
}
public class longest_string_chain {
    static boolean check(String a,String b)
    {
        if(a.length()-b.length()!=-1) return false;
        int c=0,x=0,y=0;
        while(x<a.length() && y<b.length())
        {
            if(a.charAt(x)==b.charAt(y))
            {
                x++;
            }
            else c++;
            y++;
            if(c==2) return false;
        }
        return true;
    }

    static int create(String[] w,int curr,int prev,int[][] dp)
    {
        if(curr<0) return 0;
        if(dp[prev-1][curr]!=0) return dp[prev-1][curr];
        int take=0,dont;
        if(prev==w.length || (w[curr].length()-w[prev].length()==-1 && check(w[curr],w[prev])))
        take=1+create(w, curr-1, curr,dp);
        dont=create(w, curr-1, prev,dp);
        return dp[prev-1][curr]=Math.max(take,dont);
    }

    static  int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        int[][] dp=new int[words.length+1][words.length];
       return create(words, words.length-1, words.length,dp);
    }

    public static void main(String[] args)
    {
        String[] s={"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain_dfs(s));
    }

    static  int longestStrChain_bottomup(String[] w) {
        Arrays.sort(w, (a, b)->Integer.compare(a.length(), b.length()));
        int l=w.length,max=1;
        for (String string : w) {
            System.out.print(string+" , ");
        }
        int[] dp=new int[l];
        Arrays.fill(dp,1);
        for(int i=1;i<l;i++)
        {
            for(int j=i-1;j>=0 && w[i].length()-w[j].length()==1;j--)
            {
                if(check(w[j], w[i]))
                dp[i]=Math.max(dp[i],dp[j]+1);
                max=Math.max(dp[i],max);
               // System.out.println(dp[i]);
            }
        }
        return max;
    }




    //fastest method using dfs 
    static int longestStrChain_dfs(String[] w) {
    
        Map<Integer,List<String>> map=new HashMap<>(); 
        for(String s:w)
        {
            map.computeIfAbsent(s.length(), v->new ArrayList<>()).add(s);
        }
        System.out.println(map);
        Map<String,Integer> vis=new HashMap<>();
        int max=1;
        for (String s : w) {
            max=Math.max(max,dfs(map,s,vis));
        }
        return max;
    }
    static int dfs(Map<Integer,List<String>> map,String curr,Map<String,Integer> vis)
    {
        if(vis.containsKey(curr)) return vis.get(curr);
        if(!map.containsKey(curr.length()+1)) return 1;
        int max=1;
        for(String s: map.get(curr.length()+1))
        {
            if(check(curr, s))
            {
                max=Math.max(max,1+dfs(map, s, vis));
            }
        }
        vis.put(curr, max);
        return max;
    }

    
}
