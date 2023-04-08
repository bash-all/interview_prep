package Trees;

import java.util.*;
class Pair{
    int hd;
    TreeNode r;
    Pair(int v,TreeNode q)
    {
        hd=v;r=q;
    }
}
public class top_view {
    //level order traversal keeping track ofeach new upcoming y coordinate value
   
    static ArrayList<Integer> create(TreeNode r, TreeMap<Integer,TreeNode> h)
    {
        Deque<Pair> q=new LinkedList<>();
        q.add(new Pair(0,r));
        while(!q.isEmpty())
        {
            Pair curr=q.removeFirst();
            int val=curr.hd;
            TreeNode temp=curr.r;
            if(!h.containsKey(val))
            h.put(val,temp);
            
            if(temp.left!=null)
            {
                q.add(new Pair(val-1,temp.left));
            }
            if(temp.right!=null) 
            q.add(new Pair(val+1,temp.right));
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i:h.keySet())
        {
            l.add(h.get(i).val);

        }
        return l;
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1),s=root;
        s.left=new TreeNode(2);
        s.right=new TreeNode(3);
        // s.left.left=new TreeNode(4);
        // s.left.right=new TreeNode(5);
        // s.left.left.right=new TreeNode(9);
        // s.left.left.left=new TreeNode(8);
        // // s.left.left.right.left=new TreeNode(9);
        // // s.left.left.right.left.left=new TreeNode(10);
        // s.right.left=new TreeNode(6);
        // s.right.right=new TreeNode(7);
        // s.right.right.left=new TreeNode(8);
        // s.right.right.left.right=new TreeNode(11);

        List<Integer> ans=create(root, new TreeMap<>());
       
        System.out.println(ans);

    }
    
}
