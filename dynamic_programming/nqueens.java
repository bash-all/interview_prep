package dynamicp;

import java.util.ArrayList;
import java.util.List;

public class nqueens {

    static boolean check(int[][] m,int col,int row,int n)
    {
        int r1=row,c1=col;
        if( col==0)
        return true;

        //row check
        while(col>=0)
        {
            if(m[row][col]==1) return false;
            col--;
        }
        //lower diagonal

        col=c1;
        while(col>=0 && row<n)
        {
            if(m[row][col]==1) return false;
            row++;col--;
        }

        col=c1;row=r1;
        //upper diagonal

        while(row>=0 && col>=0)
        {
            if(m[row][col]==1) return false;
            row--;col--;
        }
        return true;
    }

    static void generate(int n,int col,List<List<String>> ans,int[][] m)
    {
        if(col==n)
        {
            List<String> temp=new ArrayList<>();
            String s="";
            for(int r=0;r<n;r++)
            {
                s="";
                for(int c=0;c<n;c++)
                {
                    if(m[r][c]==1)
                    s+='Q';
                    else s+='.';
                }
                temp.add(s);
                ans.add(new ArrayList<>(temp));
                temp.clear();;
            }
            return;
        }

            for(int j=0;j<n;j++)
            {
                if(check(m,col,j,n)) 
                {
                    m[j][col]=1;
                    generate(n,col+1, ans, m);
                    m[j][col]=0;
                }
            }
        

    }

    public static void main(String[] args)
    {
        List<List<String>> l=new ArrayList<>();
        int[][] m=new int[4][4];
        generate(4, 0, l, m);
        System.out.println(l);
    }

    
}
