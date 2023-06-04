package dynamicp;

public class fibo
{
    long fib(int n)
    {
        long arr[]=new long[n+2];
        arr[1]=0;
        arr[2]=1;
        for(int i=3;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public static void main(String[] args)
    {
        fibo o=new fibo();
        System.out.println(fib_topdown(99));
        double n=Math.pow((Math.sqrt(5)+1)/2,100)/Math.sqrt(5);
        System.out.println(Math.round(n));
    }
    static int dp[]=new int[100];
    static int fib_topdown(int n)
    {
        if(n<=1)
        return n;
        else{
            
            int f1,f2;
            if(dp[n-1]>0)
            f1=dp[n-1];
            else 
            f1=fib_topdown(n-1);

            if(dp[n-2]>0)
            f2=dp[n-2];
            else
            f2=fib_topdown(n-2);

            dp[n]=f1+f2;
            return dp[n];
        }
    }
}