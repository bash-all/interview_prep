package Trees;
/*Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the 
same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false */


public class subtree_of_another_tree {
    static boolean match(TreeNode f,TreeNode r)
    {
       if(f==null && r==null ) return true;
       if(f==null || r==null ) return false;
        if(f.val==r.val)
        return match(f.left,r.left) && match(f.right,r.right);
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;

        if(match(root,subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree( root.right, subRoot);

        
    }
    
}
