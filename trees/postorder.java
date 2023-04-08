package Trees;

import java.util.*;


public class postorder {

    static void traverse(TreeNode root,List<Integer> list)
    {
        if(root==null) return;

        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }

    //iterative
    static List<Integer> traverse2(TreeNode root)
    {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        stack.push(curr);
        while(!stack.isEmpty())
        {
            curr=stack.pop();
           list.add(0,curr.val);
           if(curr.left!=null)
           stack.push(curr.left);
           if(curr.right!=null)
           stack.push(curr.right);
        }
        return list;
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1),start=root;
         start.right=new TreeNode(2);
         start=start.right;
         start.left=new TreeNode(3);
         start.right=new TreeNode(4);
         System.out.println(traverse2(root));
         System.out.println(levelOrder(root));
    }
    
    //level order traversal
    static  List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list=new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
    
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(!q.isEmpty())
        {
            int c=q.size();
            for(int i=0;i<c;i++)
            {
                curr=q.getFirst();
                ans.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                q.remove();
            }
            list.add(List.copyOf(ans));
            ans.clear();  
        }
        return list;
        q.pee
    }
}
