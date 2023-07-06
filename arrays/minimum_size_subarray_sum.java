class Solution {

  //sliding window approach
  public int minSubArrayLen(int target, int[] nums) {
        
        int x=0,y=1,n=nums.length;
        int sum=nums[0],ans=n+1;
        if(sum>=target) return 1;
        while(y<n)
        {
            sum+=nums[y];
            
            while(sum>=target) 
            {
                ans=Math.min(ans,y-x+1);
                sum-=nums[x];
                x++;
            }
            y++;
        }
        return ans==n+1?0:ans;
    }

  //binary search on prefix sum approach
    int bsearch(int[] a,int target,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]>=target) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int minSubArrayLen2(int target, int[] nums) {
        int n=nums.length,ans=n+1;
        
       int[] pre=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++) pre[i]=pre[i-1]+nums[i];
        
        for(int i=0;i<n;i++)
        {
            int t=target;
            if(i!=0) t+=pre[i-1];
            
            int ind=bsearch(pre,t,i,n-1);
            
            if(ind!=n) ans=Math.min(ans,ind-i+1);
            else break;
            //System.out.println(ans+","+ind+","+target);
        }
        
        return ans==n+1?0:ans;
    }
}
