class Solution {
    public int maxProfit(int[] a) {
       
        int[][][] dp=new int[a.length+1][2][3];
        
        
        for(int i=a.length-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                for(int k=2;k>=1;k--)
                {
                     if(j==1)
             dp[i][j][k] = Math.max(dp[i+1][0][k]-a[i],dp[i+1][1][k]);
                     else
             dp[i][j][k]=Math.max(dp[i+1][1][k-1]+a[i],dp[i+1][0][k]);
                    
                }
            }
        }
        
        return dp[0][1][2];
    }
}