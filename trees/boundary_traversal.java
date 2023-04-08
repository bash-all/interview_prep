package Trees;

import java.util.*;
public class boundary_traversal {

   
    static ArrayList<Integer> boundary(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(root.val);
        List<Integer> left=new ArrayList<>();
        left(root.left, left);
        System.out.println(left);
        ans.addAll(new ArrayList<>(left));
        left.clear();


        leaf(root, left);
        System.out.println(left);
        ans.addAll(new ArrayList<>(left));
        left.clear();


        right(root.right, left);
        System.out.println(left);
        Collections.reverse(left);
        ans.addAll(new ArrayList<>(left));
        System.out.println(ans);
        return ans;
	}

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(10),start=root;
        start.left=new TreeNode(5);
        //start.right=new TreeNode(20);
        //start.left.left=new TreeNode(3);
        start.left.right=new TreeNode(8);
        start.left.right.left=new TreeNode(7);
        //start.right.left=new TreeNode(18);
        //start.right.right=new TreeNode(25);
        //start.right.right.right=new TreeNode(2);
        boundary(root);


    }

    static void left(TreeNode root,List<Integer> list)
    {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        list.add(root.val);
        if(root.left!=null)
        left(root.left,list);
        else left(root.right,list);
    }
    static void right(TreeNode root,List<Integer> right) 
    {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        
        if(root.right!=null)
        right(root.right,right);
        else right(root.left,right);
        right.add(root.val);
    }
    static void leaf(TreeNode root,List<Integer> l)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
        l.add(root.val);return;
        }
        leaf(root.left,l);
        leaf(root.right, l);
    }

	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
         ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        ans.add(root.val);
        left(root.left, ans);
        
        leaf(root.left, ans);
        leaf(root.right,ans);
        
        right(root.right,ans);
        return ans;
        
	}
}

