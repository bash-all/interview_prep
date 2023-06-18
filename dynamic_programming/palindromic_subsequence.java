package dynamicp;

public class palindromic_subsequence {

    static int find(String s,int i,int j)
    {

        if(i>j) return 0;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j))
        return 2+find(s, i+1, j-1);

        return Math.max(find(s,i,j-1),find(s, i+1, j));

    }

    public static void main(String[] args)
    {
        System.out.println(find("bbbab",0,4));
        int[][] dp=new int[5][5];
        System.out.println(find2("bbbab",dp));
    }

    static int find2(String s,int [][]dp)
    {
        //top down dp
        // if(i>j) return 0;
        // if(i==j) return 1;

        // if(dp[i][j]!=0) return dp[i][j];

        // if(s.charAt(i)==s.charAt(j))
        // return dp[i][j]=2+find2(s, i+1, j-1,dp);

        // return dp[i][j]=Math.max(find2(s,i,j-1,dp),find2(s, i+1, j,dp)); 

        //bottom up dp
        for(int x=s.length()-1;x>=0;x--)
        {
            dp[x][x]=1;
            for(int y=x+1;y<s.length();y++)
            {
                
                if(s.charAt(x)==s.charAt(y))
                   dp[x][y]=2+dp[x+1][y-1];

                else 
                dp[x][y]=Math.max(dp[x+1][y],dp[x][y-1]);
                
            }
        }
        return dp[0][s.length()-1];
        
    }
    
}
