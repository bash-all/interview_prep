package graph;
import java.util.*;
public class word_ladder {

    static void find(Set<String> words,String curr,Queue<String> q)
    {
        char[] old=curr.toCharArray();
        for(int i=0;i<curr.length();i++)
        {
            char ch=curr.charAt(i);
            for(char j='a';j<='z';j++)
            {
                if(j==ch) continue;
                old[i]=j;
                String str=new String(old);
                if(words.contains(str))
                {
                    words.remove(str);
                    q.add(str);
                }
            }
            old[i]=ch;
        }
    }
    static int ladderLength(String begin, String end, List<String> words) {

        if(words.contains(end)==false) return 0;
        Set<String> set=new HashSet<>(words);
        Queue<String> q=new LinkedList<>();
        q.add(begin);
        int step=0;
        while(!q.isEmpty())
        {
            step++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String curr=q.remove();
                if(curr.equals(end)) return step;
                find(set,curr,q);
                
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        List<String> words=Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> ans=findLadders2("hit", "cog", words);
        System.out.println(ans);
    }

    static void create(String curr,Set<String> set,Queue<List<String>> q,List<String> temp,List<String> vis)
    {
        char[] ch=curr.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            char c=ch[i];
            for(char j='a';j<='z';j++)
            {
                if(j==c) continue;
                ch[i]=j;
                String s=String.valueOf(ch);
                if(set.contains(s))
                {
                    temp.add(s);
                    q.add(new ArrayList<>(temp));
                    temp.remove(s);
                    vis.add(s);
                }
            }
            ch[i]=c;
        }
    }
    //tle in leetcode
    static List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        Queue<List<String>> q=new LinkedList<>();
        List<String> temp1=new ArrayList<>();
        temp1.add(begin);
        q.add(temp1);
        boolean check=false;
        List<List<String>> ans=new ArrayList<>();
        Set<String> set=new HashSet<>(wordList);
        System.out.println(q);
        set.remove(begin);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            List<String> vis=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                List<String> temp=q.remove();
                String curr=temp.get(temp.size()-1);
                if(curr.equals(end)) 
                {
                    check=true;
                    ans.add(temp); continue;
                }
                create(curr,set,q,temp,vis);
                
            }
            System.out.println(q);
            
            for(String s:vis)
                set.remove(s);
            if(check) return ans;
        }
        ans.clear();
        return ans;
    }

    static void create(String curr,Set<String> set,Queue<String> q)
    {
        char[] ch=curr.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            char c=ch[i];
            for(char j='a';j<='z';j++){
                if(j==c) continue;
                ch[i]=j;
                String s=new String(ch);
                if(set.contains(s)){
                    set.remove(s);
                    q.add(s);
                }
            }
            ch[i]=c;
        }
    }
    //using dfs and bfs
    static  List<List<String>> findLadders2(String begin, String end, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        List<List<String>> ans=new ArrayList<>();
        if(!set.contains(end)) return ans;
        
        Queue<String> q=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
        q.add(begin);
        set.remove(begin);
        int step=0;boolean check=false;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String curr=q.remove();
                
                if(!map.containsKey(curr)) map.put(curr,step);
                if(curr.equals(end))
                {
                    check=true;break;
                }
                create(curr,set,q);
            }
            if(check) break;
            step++;
        }
        System.out.println(map);
        List<String> temp=new ArrayList<>();
        temp.add(end);
        dfs(end,begin,map,temp,ans);
        return ans;
    }

    static void dfs(String curr,String start,Map<String,Integer> map,List<String> temp,List<List<String>> ans)
    {
        if(curr.equals(start))
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //System.out.println(temp);
        char[] ch=curr.toCharArray();
        int step=map.getOrDefault(curr, -1);
        for(int i=0;i<ch.length;i++)
        {
            char c=ch[i];
            for(char j='a';j<='z';j++)
            {
                if(c==j) continue;
                ch[i]=j;
                String s=new String(ch);
                if(map.containsKey(s) && map.get(s)==step-1)
                {
                    temp.add(0,s);
                    dfs(s, start, map, temp, ans);
                    temp.remove(s);
                }
            }
            ch[i]=c;
        }
        int[] a=new int[3];
        

    }
}
