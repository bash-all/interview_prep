package dynamicp;
import java.util.*;
public class generate_parenthesis {
    static List<String> ans;
    static void generate(StringBuffer sb,int n,Set<String> vis)
    {
        if(n==0)
        {
            ans.add(sb.toString());
            return;
        }
        
        for(int i=0;i<=sb.length();i++)
        {
            sb.insert(i,"()");
            if(!vis.contains(sb.toString())) {
                generate(sb,n-1,vis);
                vis.add(sb.toString());
            }
            sb.delete(i, i+2);
        }
    }
    static  List<String> generateParenthesis(int n) {

        char[] temp=new char[2*n];
        //ans=new ArrayList<>();
        list=new ArrayList<>();
        //generate(new StringBuffer(),n,new HashSet<>());
        generate2(temp,n,n , 0);
      
        return list;
    }


    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(4));
    }



    //using char array
    static List<String> list;
    static void generate2(char[] temp,int left,int right,int pos)
    {
        if(left==0 && right==0)
        {
            list.add(new String(temp));
            return;
        }

        if(left<0 || left>right || pos>=temp.length) return;

        temp[pos]='(';
        generate2(temp, left-1, right, pos+1);
        temp[pos]=' ';

        temp[pos]=')';
        generate2(temp, left, right-1, pos+1);
        temp[pos]=' ';

        
        
    }
    
}
