package Trees;

import java.util.ArrayList;
import java.util.List;

public class lowest_common_ances {

    static List<TreeNode> lca(TreeNode n,List<TreeNode> temp,TreeNode p,int i)
    {
        if(n==null) return null;
        if(n!=null && n==p) 
        {
            temp.add(n);
            return temp;
        }
        //go left
        temp.add(n);
        List<TreeNode> l;
        l=lca(n.left, temp,  p,i+1);
        if(l!=null) return l;

        //go right
        temp=temp.subList(0, i+1);
    
        l=lca(n.right, temp, p,i+1);
        return l;
    }

    public static void main(String[] args)
    {
        //List<List<Integer>> ans=new ArrayList<>();
        TreeNode root=new TreeNode(3),s=root;
        s.left=new TreeNode(5);
        // s.right=new TreeNode(1);
        // s.left.left=new TreeNode(6);
        // s.left.right=new TreeNode(2);
        // s.left.right.left=new TreeNode(7);
        // s.left.right.right=new TreeNode(4);
        // s.right.left=new TreeNode(0);

        // List<TreeNode> l1=lca(root,new ArrayList<>(),s,0);
        // List<TreeNode> l2=lca(root,new ArrayList<>(),s.left,0);
        // System.out.println(l1+"\n"+l2);

        // for(int i=Math.min(l2.size(),l1.size())-1;i>=0;i--)
        // {
        //     if(l1.get(i)==l2.get(i))
        //     System.out.println(l1.get(i).val);
        // }
        List<List<TreeNode>> ans=new ArrayList<>();
        lca(root, new ArrayList<>(), s, 0, s.left, ans);
        System.out.println(ans);
        List<TreeNode> l1=ans.get(0);
        List<TreeNode> l2=ans.get(1);

         for(int i=Math.min(l2.size(),l1.size())-1;i>=0;i--)
        {
            if(l1.get(i)==l2.get(i))
            System.out.println(l1.get(i).val);
        }
    }

    //run efficiently by running for p and q simultaenously
    static void lca(TreeNode n,List<TreeNode> temp,TreeNode p,int i,TreeNode q,List<List<TreeNode>> ans)
    {
        if(n==null) return;
        if(n!=null && (n==p || n==q)) 
        {
            temp.add(n);
            ans.add(List.copyOf(temp));
        }
        //go left
        temp.add(n);
        lca(n.left, temp,  p,i+1,q,ans);

        //go right
        temp=temp.subList(0, i+1);
    
        lca(n.right, temp, p,i+1,q,ans);
    }


    //most efficient
    static TreeNode lca(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null) return null;

        if(root==p || root==q) return root;

        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);

        if(left==null && right==null) return null;
        if(left==null) return right;
        if(right==null) return left;

        return root;

    }
}
