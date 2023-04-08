import java.util.*;
public class alien_dictionary {

    static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int[] indeg=new int[K];
        
        for(int i=0;i<N-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];
            for(int j=0;j<Math.min(s1.length(),s2.length());j++)
            {
                if(s1.charAt(j)==s2.charAt(j)) continue;
                adj.computeIfAbsent(s1.charAt(j)-'a',value->new ArrayList<>()).add(s2.charAt(j)-'a');
                indeg[s2.charAt(j)-'a']++;
                break;
            }
            
        }
        System.out.println(adj);
        Deque<Integer> q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<K;i++)
        {
            if(indeg[i]==0) q.add(i);
        }

        while(!q.isEmpty())
        {
            int curr=q.remove();
            ans.append((char)(curr+'a'));

            if(adj.containsKey(curr))
            {
                for(int i:adj.get(curr))
                {
                    indeg[i]--;
                    if(indeg[i]==0) q.add(i);
                }
            }
        }
        return ans.toString();
        
    }

    public static void main(String[] args)
    {
        System.out.println(findOrder(new String[]{"baa","abcd","abca","cab","cad"}, 5, 4));
        System.out.println(getAlienLanguage(5,new String[]{"baa","abcd","abca","cab","cad"} ).toString());
    }
    

    //leetcode
    public static char[] getAlienLanguage(int N, String[] dict) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        Map<Integer,Integer> indeg=new HashMap<>();
        
        for(int i=0;i<N-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];
            for(int j=0;j<Math.min(s1.length(),s2.length());j++)
            {
                if(s1.charAt(j)==s2.charAt(j)) continue;
                adj.computeIfAbsent(s1.charAt(j)-'a',value->new ArrayList<>()).add(s2.charAt(j)-'a');
                indeg.put(s2.charAt(j)-'a',indeg.getOrDefault(s2.charAt(j)-'a', 0)+1);
                if(!indeg.containsKey(s1.charAt(j)-'a')) indeg.put(s1.charAt(j)-'a',0);
                break;
            }
        }
        System.out.println(adj+"\n"+indeg);
        int K=indeg.size();
        Deque<Integer> q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        for(int i:indeg.keySet())
        {
            if(indeg.get(i)==0) q.add(i);
        }

        while(!q.isEmpty())
        {
            int curr=q.remove();
            ans.append((char)(curr+'a'));

            if(adj.containsKey(curr))
            {
                for(int i:adj.get(curr))
                {
                    indeg.put(i,indeg.get(i)-1);
                    if(indeg.get(i)==0) q.add(i);
                }
            }
        }
        if(ans.length()!=K) return new char[]{};
        return ans.toString().toCharArray();
    }
}
