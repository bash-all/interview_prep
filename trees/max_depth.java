package Trees;
/*
 * Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 */
import java.util.*;
public class max_depth {

    static int diameter(TreeNode root,int[] max){

        if(root==null)   return 0;
        
        int lh=diameter(root.left,max);
        int rh=diameter(root.right,max);
        max[0]=Math.max(lh+rh,max[0]);

        return 1+Math.max(lh,rh);
    }
    static int height(TreeNode root)
    {
        if(root==null) return -1;
         
        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args)
    {
        TreeNode t=new TreeNode(1);
        insert(t,2);
        insert(t,3);
        insert(t,4);
        insert(t,5);
        System.out.println(height(t));
        System.out.println(diameter(t,new int[]{0}));

    }
    static void insert(TreeNode temp, int key)
    {
 
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(temp);
 
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
