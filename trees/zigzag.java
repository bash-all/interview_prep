package Trees;

import java.util.*;
public class zigzag {
    

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level=1;
        List<List<Integer>> l=new ArrayList<>();
        Deque<TreeNode> q=new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            level++;
            int c=q.size();
            for(int i=0;i<c;i++)
            {
                TreeNode curr=q.removeFirst();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(level%2==1)
            {
                Collections.reverse(temp);
                l.add(new ArrayList<>(temp));
            }
            else l.add(new ArrayList<>(temp));

            temp.clear();
        }
        return l;
        
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(3),s=root;
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));

    }

    //recursive
    void create(TreeNode c,int l,List<List<Integer>> ans)
    {
        if(c==null) return;
        
        if(ans.size()<=l)
        {
            List<Integer> temp=new ArrayList<>(); ans.add(temp);
        }
        List<Integer> temp=ans.get(l);
        if(l%2==0) temp.add(c.val);
        else temp.add(0,c.val);
        
        create(c.left,l+1,ans);
        create(c.right,l+1,ans);
    }
    
}
