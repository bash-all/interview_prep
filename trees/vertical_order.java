package Trees;
import java.util.*;
public class vertical_order {

    static HashMap<Integer,HashMap<Integer,List<Integer>>> h=new HashMap<>();
    static int min=0,max=0;
    static void traversal(TreeNode r,int n,int x)
    {
        if(r==null) return;
        HashMap<Integer,List<Integer>> m=h.getOrDefault(n, new HashMap<>());
        List<Integer> list=m.getOrDefault(x, new ArrayList<>());
        list.add(r.val);
        m.put(x,list);
        h.put(n,m);
        //System.out.println(r.val+","+n);
        min=Math.min(min,n);
        max=Math.max(max,n);
        traversal(r.left,n-1,x+1);
        traversal(r.right,n+1,x+1);
        
    }
    static List<List<Integer>> verticalTraversal(TreeNode root) {
       
        traversal(root,0,0);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            HashMap<Integer,List<Integer>> map=h.get(i);
            List<Integer> level=new ArrayList<>();
            for(int j=0;map.size()>0;j++)
            {
                List<Integer> ele=map.getOrDefault(j, null);
                if(ele!=null && ele.size()>0)
                {
                    
                    Collections.sort(ele);
                    level.addAll(ele);
                    map.remove(j);
                }

            }
            if(level.size()>0)
            list.add(level);
            
        }
        
        return list;
    }

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(3),start=root;
        start.left=new TreeNode(9);
        start.right=new TreeNode(20);
        start.left.left=new TreeNode(1);
        start.left.right=new TreeNode(2);
        start.right.left=new TreeNode(15);
        start.right.right=new TreeNode(7);
        verticalTraversal(root);
    }
    
}
