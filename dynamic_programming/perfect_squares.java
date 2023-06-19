package dynamicp;

import java.util.ArrayList;
import java.util.List;

public class perfect_squares {
    //dp solution
    static int count(int n)
    {
        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];

    }
    //static dp solution for mutliple test cases faster
    static List<Integer> list=new ArrayList<>();
    public int numSquares(int n) {
        if(list.size()==0)
        list.add(0);
        int max,size;
        while(list.size()<=n)
        {
            max=Integer.MAX_VALUE;
            size=list.size();
            
            for(int j=1;j*j<=size;j++)
            {
                max=Math.min(max,list.get(size-j*j)+1);
            }
            list.add(max);
        }
        
        return list.get(n);
        
        
    }
    
}
