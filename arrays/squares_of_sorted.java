package array;
/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number 
sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

public class squares_of_sorted
{
    static void mergesort(int[] a,int s,int e)
    {
        int mid=(s+e)/2;
        if(s<e)
        {
            mergesort(a,s,mid);
            mergesort(a,mid+1,e);
            merge(a,s,mid,e);
        }
    }
    static void merge(int[] arr,int s,int mid,int e)
    {
        int s1=mid-s+1;
        int s2=e-mid;
        int x=0,y=0;
        int left[]=new int[s1];
        int right[]=new int[s2];
        for(int i=0;i<s1;i++)
        {
            left[i]=arr[s+i];
        }
        for(int i=0;i<s2;i++)
        {
            right[i]=arr[mid+i+1];
        }
        int k=s;
        while(x<s1 && y<s2)
        {
            if(left[x]<right[y])
            {
                arr[k++]=left[x++];
            }
            else 
            {
                arr[k++]=right[y++];
            }
        }
        while(x<s1)
        {
            arr[k++]=left[x++];
        }
        while(y<s2)
        {
            arr[k++]=right[y++];
        }
    }
    public static void main(String[] args)
    {
        int a[]={-2,-1,0,1,3,4,5};
       /* for(int i=0;i<a.length;i++)
        {
            a[i]=a[i]*a[i];
        }
        mergesort(a,0,a.length-1);
        */
        int b[]=merge2(a);
        for(int i=0;i<a.length;i++)
        {
            System.out.print(b[i]+",");
        }

    }
    static int[] merge2(int[] a)
    {
        int r[]=new int[a.length];
        int i=0,j=a.length-1;
        for(int p=j;p>=0;p--)
        {
            if(Math.abs(a[i])>=Math.abs(a[j]))
            {
            r[p]=a[i]*a[i];
            i++;
            }else
            {
            r[p]=a[j]*a[j];
            j--;
            }
        }
        return r;

    }
    
}
