package dynamicp;
/*
 *You are given an integer array nums. You want to maximize the number of points you get by performing the following 
 operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 
and every element equal to nums[i] + 1.

Return the maximum number of points you can earn by applying the above operation some number of times.

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 */

public class delete_and_earn {

    static int count(int[] a)
    {
        int l=a.length;
        int bucket[]=new int[10001];
        int rob[]=new int[10001];
        for(int i=0;i<l;i++)
        {
            bucket[a[i]]+=a[i];
        }
        rob[1]=bucket[1];
        for(int i=2;i<10001;i++)
        {
            rob[i]=Math.max(rob[i-2]+bucket[i],rob[i-1]);
            
        }
        return rob[10000];
    }
    public static void main(String[] args)
    {
        System.out.println(count2(new int[]{2,2,3,3,3,4}));
    }
    //efficient approach
    static int count2(int[] a)
    {
        int max=0;
        for (int i : a) {
            max=Math.max(i,max);
        }

        int freq[]=new int[max+1];
        for (int i : a) freq[i]++;
        int[] dp=new int[max+1];
        dp[1]=freq[1]*1;
        for(int i=2;i<max+1;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+i*freq[i]);

        }
        return dp[max];


    }
    
}
