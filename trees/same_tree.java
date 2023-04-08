package Trees;
/*Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Input: p = [1,2,3], q = [1,2,3]
Output: true

Input: p = [1,2], q = [1,null,2]
Output: false

Input: p = [1,2,1], q = [1,1,2]
Output: false */


import java.util.*;

public class same_tree {
    static boolean match(TreeNode f,TreeNode s)
    {
        if(f==null && s==null) return true;

        if(f==null || s==null ) return false;

        if(f.val==s.val) return match(f.left,s.left) && match(f.right,s.right);
        return false;

    }
    static void display(TreeNode root)
    {
        if(root==null) return;
        System.out.print(root.val+",");

       display(root.left);
       display(root.right);

    }
   
    public static void main(String[] args)
    {
        TreeNode t=new TreeNode(1);
        insert(t,2);
        insert(t,3);
        insert(t,4);
        insert(t,5);
        TreeNode t2=new TreeNode(1);
        insert(t2,2);
        insert(t2,3);
        insert(t2,4);
        insert(t2,5);
        display(t);
        //display(t2);
        System.out.println(match(t,t2));


    }
    static void insert(TreeNode temp, int key)
    {
 
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(temp);
        TreeNode root=temp;
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            //System.out.print(q.peek().val+",");
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }


       
    }
    
}
