package dynamicp;

import java.util.Arrays;

public class longest_increasing_sub {
    //recursion approach
    static int max_length(int curr_ind,int prev,int[] a,int n)
    {
        if(curr_ind>=n) return 0;
        System.out.println(curr_ind+" , "+prev);

        int take=0,dont=max_length(curr_ind+1, prev, a, n);
        if(a[curr_ind]>prev)
        take=1+max_length(curr_ind+1, a[curr_ind], a, n);
        System.out.println(curr_ind +"  ,"+prev +", "+ take+"," +dont);
        return Math.max(take,dont);
    }
    //recursion with memoization
    static int max_length2(int[] a,int n,int prev,int curr,int[][] dp)
    {
        if(curr>=n) return 0;
        if(dp[curr][prev+1]!=0) return dp[curr][prev+1];

        int take=0,dont=max_length2(a, n, prev, curr+1, dp);
        if(prev==-1 || a[curr]>a[prev])
        take=1+max_length2(a, n, curr, curr+1, dp);
        
        dp[curr][prev+1]=Math.max(take,dont);
        return dp[curr][prev+1];
    }

    //using basic dynamic programming recursion with 1d  
    static int inc(int[] a)
    {
        int[] dp=new int[a.length+1];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j]<a[i])
                dp[i]=Math.max(dp[i],dp[j]+1);
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        System.out.println(inc(new int[]{1,3,6,7,9,4,10,5,6}));
        int[] a={1,5,6,7};
        //int[][]dp=new int[a.length][a.length+1];
        // System.out.println(max_length(0, 0, a, a.length));
        // System.out.println(max_length2(a,4, -1,0,dp ));
        // for(int i=0;i<a.length;i++)
        // {
        //     for(int j=0;j<dp[0].length;j++)
        //     {
        //         System.out.print(dp[i][j]+",");
        //     }
        //     System.out.println();
        // }
        System.out.println(find(a));
    }


    //0(nlogn) approach best using dp and binary search
    static int find(int[] a)
    {
        int n=a.length;
        int[] tail=new int[n];
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(j==0) 
            tail[j++]=a[i];
            else if(tail[j-1]<a[i])
            {
                tail[j++]=a[i];
            }
            else if(tail[0]>a[i])
            tail[0]=a[i];
            else 
            {
                int x=-1,y=j-1;
                while(y-x>1)
                {
                    int mid=x+(y-x)/2;
                    if(tail[mid]>=a[i])
                    y=mid;
                    else x=mid;

                }
                tail[y]=a[i];
            }
        }
        return j;
        
    }
    //fastest and in place list mantainence
    static int findLISlength(int[] a)
    {
    int lis=0,len=a.length;
    for(int i=1;i<len;i++)
    {
        if(a[i]>a[lis])
        {
            a[++lis]=a[i];
        }
        else
        {
            for(int j=lis-1;;j--)
            {
                if(j<0 || a[j]<a[i])
                {
                    a[j+1]=a[i];
                    break;
                }
            }
        }
    }
    return lis+1;
}
    
}
