package Trees;

import java.util.Deque;
import java.util.LinkedList;

class Pair 
{
    TreeNode r;int val;
    Pair(TreeNode t, int v)
    {
        r=t;val=v;
    }
}
public class max_width {

    public int widthOfBinaryTree(TreeNode r) {
        
        Deque<Pair> q=new LinkedList<>();
        q.add(new Pair(r, 0));
        int max=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int first=q.peek().val;
            int start=0,last=0;
            for(int i=0;i<size;i++)
            {
                Pair curr=q.removeFirst();
                int val=curr.val-first;
                TreeNode temp=curr.r;
                if(i==0) start=val;
                if(i==size-1) last=val;
                
                if(temp.left!=null)
                {
                    q.add(new Pair(temp.left, 2*val+1));
                }
                if(temp.right!=null)
                {
                    q.add(new Pair(temp.right, 2*val+2));
                }
                max=Math.max(max,last-start+1);
            }
        }
        return max;
        
    }


    static String removeDigit(String s, char d) {
        
        String a=s;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==d)
            {
                String temp=s.substring(0,i)+s.substring(i+1); 
                if(temp.compareTo(a)>0)
                {
                    a=temp+"";
                }
            }
        }
        return a;
        
    }
    public static void main(String[] args)
    {
        System.out.println(removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3'));
    }

    
}
