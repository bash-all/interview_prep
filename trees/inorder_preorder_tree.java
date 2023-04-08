package Trees;

import java.util.*;
public class inorder_preorder_tree {

    static TreeNode build(int[] pre,int[] in,Map<Integer,Integer> h,int prei,int preend,int ini,int inend)
    {
        if(prei>preend || ini>inend) return null;
        TreeNode root=new TreeNode(pre[prei]);

        int index=h.get(pre[prei]);
        int nodes_left=index-ini;

        root.left=build(pre, in, h, prei+1, prei+nodes_left, ini, index-1);

        root.right=build(pre, in, h, prei+nodes_left+1, preend, index+1, inend);

        return root;
    }
    static TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer,Integer> h=new HashMap<>();
        
        for(int i=0;i<in.length;i++)
        {
            h.put(in[i],i);   
        }
        return build(pre, in, h, 0, pre.length-1, 0, in.length-1);
    }


    //from postorder and inorder
    TreeNode build2(int[] in,int[] post,Map<Integer,Integer> h,int istart,int iend,int pstart,int pend)
    {
        if(istart>iend || pend>pstart) return null; 
        TreeNode root=new TreeNode(post[pend]);
        int index=h.get(post[pend]);
        int no=index-istart;

        root.left=build2(post, in, h, istart, index-1, pstart, pstart+no-1);
        root.right=build2(post, in, h,index+1 , iend, pstart+no, pend-1);
        return root;

    }
    public TreeNode buildTree2(int[] in, int[] post) {
        Map<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<in.length;i++)
        {
            h.put(in[i],i);
        }
        return build2(in,post,h,0,in.length-1,0,in.length-1);
        
    }
    
}
