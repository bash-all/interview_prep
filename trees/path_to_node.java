package Trees;
import java.util.*;
public class path_to_node {
    static boolean match(List<Integer> temp,TreeNode curr,int b)
    {
        if(curr==null) return false;
        if(curr.val==b)
        {
            temp.add(curr.val);
            return true;
        }
        temp.add(curr.val);
        if(match(temp,curr.left,b)) return true;
        if(match(temp,curr.right,b)) return true;
        temp.remove(temp.size()-1);
        
        return false;
    }
    static int[] solve(TreeNode A, int B) {
        
        List<Integer> ans=new ArrayList<>();
        match(ans,A,B);
        System.out.println(ans);
        int[] res=new int[ans.size()];
        int k=0;
        for(Integer a:ans) res[k++]=a;
        return res;
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);root.left.right=new TreeNode(5);

        //List<Integer> ans=new ArrayList<>();
        int[] a=solve(root,5);
        
    }
    
}
