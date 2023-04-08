package Trees;

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 */

public class diameter {

    static int max=0;
    //brute force
    static int maxDepth(TreeNode n)
    {
        if(n==null) return 0;
        
        return 1+Math.max(maxDepth(n.left),maxDepth(n.right));
    }
   
    static void find(TreeNode root)
    {
        if(root==null) return;
            
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        
        max=Math.max(max,left+right);
        find(root.left);
        find(root.right);
       
    }
    public static void main(String[] args)
    {

        TreeNode root=new TreeNode(1),start=root;
        start.right=new TreeNode(2);
        start=start.right;
        start.left=new TreeNode(3);
        start.right=new TreeNode(4);
        find(root);
        System.out.println(max);
    }

    //efficient approch
    
    
}
