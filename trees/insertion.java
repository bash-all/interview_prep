package Trees;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 */
class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class insertion {
   List<TreeNode> tree;
    public insertion(TreeNode root) {
        tree=new ArrayList<>();
        tree.add(root);
        int i=0;
        while(i<tree.size())
        {
            if(tree.get(i).left!=null) tree.add(tree.get(i).left);
            if(tree.get(i).right!=null) tree.add(tree.get(i).right);
            i++;
        }
        
    }
    public int insert(int val) {
        TreeNode treenode=new TreeNode(val);
        int n=tree.size();
        tree.add(treenode);
        if(n%2==1)
        tree.get((n-1)/2).left=treenode;
        else
        tree.get((n-1)/2).right=treenode;
        return tree.get((n-1)/2).val;
        
    }
    
    public TreeNode get_root() {
        return tree.get(0);
    }
    public void display(TreeNode root)
    {
        System.out.print(tree.get(0).val+",");
        for(int i=0;i<tree.size();i++)
        {
            if(tree.get(i).left!=null) System.out.print(tree.get(i).left.val+",");
            if(tree.get(i).right!=null) System.out.print(tree.get(i).right.val+",");
        }

    }
    public static void main(String[] args)
    {
        TreeNode t=new TreeNode(1);
    insertion obj = new insertion(t);
  int param_1 = obj.insert(2);
  int param_2 = obj.insert(3);
  int param_3 = obj.insert(4);
  System.out.println(obj.get_root().val);
 obj.display(t);


    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */


    

