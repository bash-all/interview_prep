class Solution {
    //bfs iterative
    public int minDepth(TreeNode root) {
       if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        int depth=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            boolean flag=false;
            for(int i=0;i<s;i++)
            {
                TreeNode curr=q.remove();
                if(curr.left==null && curr.right==null) 
                {
                    flag=true;
                    break;
                }
                
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);

            }
            
            if(flag) break;
            depth++;
        }
        
        return depth;
    }

  //recursive dfs
  public int minDepth2(TreeNode root) {
        
        if(root==null) return 0;
        
        if(root.left==null) return 1+minDepth2(root.right);
        if(root.right==null) return 1+ minDepth2(root.left);
        
        return 1+Math.min(minDepth2(root.left),minDepth2(root.right));
    }
}
