package algorithms_plan.sliding_windows;
/*
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, 
 * return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

public class min_sum_subarray {
    static int find(int[] a,int t)
    {
        int min=Integer.MAX_VALUE;
        int s=0;
        for(int i=0,j=0;j<a.length;j++)
        {
            s=s+a[j];
            while(s>=t)
            {
                min=Math.min(min,j-i+1);
                s=s-a[i++];
            }
            
        }
        if(min==Integer.MAX_VALUE)
        return 0;
        return min;
    }
    public static void main(String[] args)
    {
        System.out.println(find(new int[]{2,3,1,2,4,3},7));
    }

    
}
