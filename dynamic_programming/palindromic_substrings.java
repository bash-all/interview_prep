package dynamicp;
/*Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */

public class palindromic_substrings {
    static int find(String s,int x,int y)
    {
        int a=0;
        while(y<s.length() && x>=0 && s.charAt(x)==s.charAt(y))
        {
            x--;y++;
            a++;
        }
        System.out.print(a+",");
        
        return a;

    }

    static int count(String s)
    {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(i==0)
            sum+=1;
            else if(i==s.length()-1)
            sum+=s.charAt(i)==s.charAt(i-1)? 2:1;
            else
            {
                if(s.charAt(i)==s.charAt(i-1) || s.charAt(i-1)==s.charAt(i+1))
                sum+=1+find(s,i-1,i+1)+find(s,i-1,i);
                else
                sum+=1;
            }
            System.out.println(sum);

        }
        
        return sum;
    }
    public static void main(String[] args)
    {
        System.out.println(count("aaaaa"));

    }
    
}
