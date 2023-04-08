import java.util.*;
class Pair{
    int hd;
    TreeNode r;
    Pair(int v,TreeNode q)
    {
        hd=v;r=q;
    }
}
public class bottom_view {

    static ArrayList<Integer> view(TreeNode root)
    {
        Map<Integer,TreeNode> h=new TreeMap<>();
        Deque<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty())
        {
            Pair temp=q.removeFirst();
            TreeNode curr=temp.r;
            int val=temp.hd;

            h.put(val,curr);
            if(curr.left!=null) q.add(new Pair(val-1,curr.left));
            if(curr.right!=null) q.add(new Pair(val+1,curr.right));
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i: h.keySet())
        {
            l.add(h.get(i).val);

        }
        return l;
    } 
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1),s=root;
        s.left=new TreeNode(2);
        s.right=new TreeNode(3);
        // s.left.left=new TreeNode(4);
        // s.left.right=new TreeNode(5);
        // s.left.left.right=new TreeNode(9);
        // s.left.left.left=new TreeNode(8);
        // // s.left.left.right.left=new TreeNode(9);
        // // s.left.left.right.left.left=new TreeNode(10);
        // s.right.left=new TreeNode(6);
        // s.right.right=new TreeNode(7);
        // s.right.right.left=new TreeNode(8);
        // s.right.right.left.right=new TreeNode(11);
        System.out.println(view(root));
    }
}
