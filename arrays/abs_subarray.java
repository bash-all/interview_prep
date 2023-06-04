package array;
/*
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] 
is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:
If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
Example 2:

Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9
ans:44

*/

public class abs_subarray 
{
    static int maxsum(int[] a)
    {
        int s=0,max_s=Integer.MIN_VALUE;
        for(int i=a.length-1;i>=0;i--)
        {
           s=s+a[i];
           max_s=Math.max(max_s,Math.max(Math.abs(a[i]),Math.abs(s)));
           if(max_s==Math.abs(a[i]))
           s=a[i];
           System.out.println(s+"  "+max_s+"  "+a[i]);
        }
        return Math.abs(max_s);
    }
    public static void main(String[] args)
    {
        int[] a={-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9};
        System.out.println(maxsum(a));
    }
    
}
