package graph;

import java.util.*;

public class nodes_at_dis_k {

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode,TreeNode> h=new HashMap<>();
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int c=q.size();
            for(int i=0;i<c;i++)
            {
                TreeNode curr=q.removeFirst();
                if(curr.left!=null)
                {
                    h.put(curr.left,curr);
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    h.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
            
        }

        
        q.clear();
        
        
        q.add(target);
        List<TreeNode> visit=new ArrayList<>();
        visit.add(target);
        while(k!=0)
        {
            k--;
            int c=q.size();
            for(int i=0;i<c;i++)
            {
                TreeNode curr=q.removeFirst();
                if(curr.left!=null && visit.contains(curr.left)==false)
                {
                    q.add(curr.left);
                    visit.add(curr.left);
                }
                 if(curr.right!=null && visit.contains(curr.right)==false)
                {
                    q.add(curr.right);
                    visit.add(curr.right);
                }
                TreeNode parent=curr==root? root: h.get(curr);
                 if( visit.contains(parent)==false)
                {
                    q.add(parent);
                    visit.add(parent);
                }
            } 
        }
        
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty())
        {
            list.add(q.pop().val);
        }
        return list;
        
        
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);

        root.left.right=new TreeNode(2);
        root.left.left=new TreeNode(6);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right.left=new TreeNode(0);

        System.out.println(distanceK(root, root.left, 2));
    }
    
}
