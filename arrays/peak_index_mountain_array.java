class Solution {
    public int peakIndexInMountainArray(int[] a) {
        
        int n=a.length;
        int x=0,y=n-1;
        
        while(x<=y)
        {
            int mid=x+(y-x)/2;
            
            if(mid!=0 && mid!=n-1 && a[mid]>a[mid+1] && a[mid-1]<a[mid])
            {
                return mid;
            }
            else if(a[mid]<a[mid+1])
                x=mid+1;
            else
                y=mid-1;
        }
        return -1;
    }
}
