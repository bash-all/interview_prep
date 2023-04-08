package array;
/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3 */

public class find_duplicate {

    static int result(int[] a)
    {
        String s="";
        for(int i=0;i<a.length;i++)
        {
            String ch="'"+Integer.toString(a[i])+"'";
            if(s.indexOf(ch)!=-1)
            return a[i];
            else
            s=s+"'"+ch+"'";
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] a={18,13,14,17,9,19,7,17,4,6,17,5,11,10,2,15,8,12,16,17};
        System.out.println(findup(a));
    }
    //Floyd algorithm of tortoise hare

    static int findup(int[] a)
    {
        int slow=a[0],fast=a[a[0]];
        while(slow!=fast)
        {
            slow=a[slow];
            fast=a[a[fast]];
        }
        fast=0;
        while(slow!=fast)
        {
            slow=a[slow];
            fast=a[fast];
        }
        return fast;

    }
    
}
