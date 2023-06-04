package dynamicp;

//import java.util.Arrays;

public class longest_common_subsequence {

    //recursive solution tht gives tle
    static int findmax(int ind1,int ind2,String s1,String s2)
    {

        if(ind1<0 || ind2<0)
        return 0;
        if(s1.charAt(ind1)==s2.charAt(ind2))
        return 1+findmax(ind1-1, ind2-1, s1, s2);


        return Math.max(findmax(ind1-1,ind2,s1,s2),findmax(ind1, ind2-1, s1, s2));
    }

    public static void main(String[] args)
    {
        System.out.println(findmax(4,4,"adebc","dcadb"));

        int[][] dp=new int[3][3];
       // Arrays.fill(dp, -1);
        // System.out.println(find("acd", "ced", 0, 0, dp));

        // for(int i=0;i<3;i++)
        // {
        //     for(int j=0;j<3;j++)
        //     System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }

        int ans=find2("adebd", "adbde", 0, 0);
    }
    

    //memoization with overlapping subproblems
    static int find(String s1,String s2,int i,int j,int[][] dp)
    {
        if(i>=s1.length() || j>=s2.length() ) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
        return dp[i][j]=1+find(s1, s2, i+1, j+1, dp);

        return dp[i][j]=Math.max(find(s1, s2, i+1, j, dp),find(s1, s2, i, j+1, dp));

    
         
        
    }

    //iterative  bottom up dp and two 1d array solution
    static int find2(String s1,String s2,int x,int y)
    {
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];

                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n][m]);
      

        return dp[n][m];
        //use of 2 1d arrays

    }
}
