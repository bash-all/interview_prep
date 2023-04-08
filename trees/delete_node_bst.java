package Trees;

import java.util.ArrayList;
import java.util.List;

public class delete_node_bst {
    static TreeNode helper(TreeNode root)
    {
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        
        TreeNode left=root.left,curr=left;
        while(curr.right!=null) curr=curr.right;
        curr.right=root.right;
        return left;
        
    }
    static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head=root;
        if(root!=null && root.val==key){
            head=helper(root);
            return head;
        }
        while(root!=null)
        {
            if(root.val>=key)
            {
                if(root.left!=null && root.left.val==key)
                {
                    root.left=helper(root.left);
                    break;
                }
                else root=root.left;
            }
            else
            {
                if(root.right!=null && root.right.val==key) {
                    root.right=helper(root.right);
                    break;
                }
                else root=root.right;
            }
        }
        return head;
        
        
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(4);
        //root.right=new TreeNode(6);

        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(7);
        List<Integer> res=new ArrayList<>();
        
        inorder(root, res);
        TreeNode ans=deleteNode(root, 4);
        res.clear();
        
        inorder(ans, res);
        System.out.println(res);

    }

    static void inorder(TreeNode root,List<Integer> ans)
    {
        if(root==null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
    
}
