package dynamicp;
import java.util.*;
public class frog_jump_k {

        static int count(int[] a,int k)
        {
            int l=a.length;
            int[] dp=new int[l];
            for(int i=1;i<l;i++)
            {
                int max=Integer.MAX_VALUE;
                for(int j=i-1;j>=0 && j>=i-k;j--)
                {
                    max=Math.min(max,Math.abs(a[i]-a[j])+dp[j]);
                  dp[i]=max;
                }
            }
            return dp[l-1];
        }
     
        public static void main(String[] args) 
        {
            Scanner sc=new Scanner(System.in);
          int l=sc.nextInt();
          int k=sc.nextInt();
          int[] a=new int[l];
          for(int i=0;i<l;i++)
            a[i]=sc.nextInt();
            System.out.println(count(a, k));
        }
        
    
    
}
