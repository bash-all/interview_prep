package dynamicp;

import java.util.Arrays;

public class house_robber {
    //pure recursive approach
    int max1(int[] a,int n)
    {
        if(n<0)
        return 0;
         return Math.max(max1(a,n-2)+a[n],max1(a,n-1));
    }
    //recusive with memeo
    static int rob[];
    static int max(int[] a,int n)
    {
        if(n<0) return 0;
        if(rob[n]>=0)
        return rob[n];
    
        int r= Math.max(max(a,n-2)+a[n],max(a,n-1));
        rob[n]=r;
        return rob[n];

    }
    //iterative
    static int max3(int[] a,int n)
    {
        int[] rob=new int[n];
        rob[0]=a[0];
        for(int i=1;i<n;i++)
        {
            if(i==1) rob[i]=Math.max(a[i],a[i-1]);
            else
            rob[i]=Math.max(rob[i-2]+a[i],rob[i-1]);
        }
        return rob[n-1];
    }
    public static void main(String[] args)
    {
        int[] a={1,2,3,1};
        rob=new int[a.length];
        // Arrays.fill(a,-1);
        // System.out.println(max(a,a.length-1));
        // Arrays.fill(rob,0);
        System.out.println(max3(a,4));
    }
}
