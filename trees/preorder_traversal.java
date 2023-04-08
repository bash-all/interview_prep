package Trees;

import java.util.ArrayList;
//import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class preorder_traversal {
     //recursive approach
     static void preorder(TreeNode root,List<Integer> list)
     {
         if(root==null) return;
 
         list.add(root.val);
         preorder(root.left, list);
         preorder(root.right, list);
 
     }
 
     public static void main(String[] args)
     {
         TreeNode root=new TreeNode(1),start=root;
         start.right=new TreeNode(2);
         start=start.right;
         start.left=new TreeNode(3);
         start.right=new TreeNode(4);
         //List<Integer> list=new ArrayList<>();
        //  preorder(root, list); 
        System.out.println(preorder2(root));
         //System.out.println(list);
 
     }

     //iterative
     static List<Integer> preorder2(TreeNode root)
     {
        //using deque
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode curr=stack.pop();
            if(curr!=null)
            {
                stack.push(curr.right);
                stack.push(curr.left);
                list.add(curr.val);
            }
        }
        return list;
     }

     //morris
     public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode last=curr.left;
                while(last.right!=null && last.right!=curr) last=last.right;
                
                if(last.right==null){
                    last.right=curr;
                    ans.add(curr.val); 
                    curr=curr.left;
                   
                }
                else
                {
                    last.right=null;
                    curr=curr.right;
                 
                }
               
            }
            else
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            
        }
        return ans;
        
    }
     
    
}
