package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorder_traversal {

    //inorder in bst gives sorted order elements
    static void traverse(TreeNode root,List<Integer> list)
    {
        if(root==null) return;

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
        
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1),start=root;
         start.right=new TreeNode(2);
         start=start.right;
         start.left=new TreeNode(3);
         start.right=new TreeNode(4);
        //  List<Integer> list=new ArrayList<>();
        //  traverse(root, list);
         System.out.println(inorder2(root));

    }
    //iterative
    static List<Integer> inorder2(TreeNode root)
    {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty())
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            list.add(curr.val);
            curr=curr.right;

        }
        return list;
    }

    //recursve min absolute diff in bst
    TreeNode prev=null;
    int  min=Integer.MAX_VALUE;
    
    public int get(TreeNode n)
    {
        if(n==null ) return min;
        get(n.left);
        
        if(prev!=null) 
            min=Math.min(min,n.val - prev.val);
        prev=n;
        get(n.right);
        return min;
        
    }
    public int getMinimumDifference(TreeNode root) {
        
       return get(root);
        
    }

   
}
